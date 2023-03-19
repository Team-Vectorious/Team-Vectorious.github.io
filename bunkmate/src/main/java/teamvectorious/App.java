package teamvectorious;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Hello");
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://TeamVectorious:Victory@cluster0.3dvb9lf.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("RoomingData");
            MongoCollection<Document> collection = database.getCollection("Users");
            Document doc = collection.find(eq("firstName", "Raymar")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }

            Document document = new Document();
            document.append("firstName", "Abhi");
            document.append("lastName", "Neelam");
            document.append("email", "lonecoder@gmail.com");
            document.append("phoneNumber", "999888777");
            document.append("password", "hello");
            //Inserting the document into the collection
            collection.insertOne(document);
        }
    }
    
}
