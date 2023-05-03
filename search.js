const { MongoClient } = require("mongodb");
const mongoose = require("mongoose");
const express = require("express");
const app = express();
const port = 3000;
app.use(express.static(__dirname + '/public'));
const fs = require('fs');
// Set up EJS as the view engine
app.set("view engine", "ejs");

// Replace the uri string with your MongoDB deployment's connection string.
const uri = "mongodb+srv://TeamVectorious:Victory@cluster0.3dvb9lf.mongodb.net/?retryWrites=true&w=majority";
const client = new MongoClient(uri);

// Connect to MongoDB
async function connectToDb() {
    try {
        await client.connect();
        console.log("Connected to MongoDB");
    } catch (err) {
        console.error(err);
    }
}
connectToDb();

// Set up route for searching
app.get("/", async (req, res) => {
    try {
        // Retrieve data from MongoDB
        const db = client.db("RoomingData");
        const coll = db.collection("roomListings");
        const userColl = db.collection("Users");
        const searchTerm = req.query.searchTerm;
        const regex = new RegExp(searchTerm, "i");
        const cursor = coll.find({ $or: [{ title: regex }, { description: regex }] });
        const cursor2 = userColl.find();
        const listings = await cursor.toArray();
        const names = await cursor2.toArray();

        // Render EJS template with data
        res.render("search", { listings: listings, names: names });
    } catch (err) {
        console.error(err);
        res.render("error");
    }
});

// Start server
app.listen(port, () => {
    console.log(`Server listening on port ${port}`);
});

// Close MongoDB connection on process exit
process.on("SIGINT", () => {
    client.close().then(() => console.log("Disconnected from MongoDB"));
    process.exit();
});
