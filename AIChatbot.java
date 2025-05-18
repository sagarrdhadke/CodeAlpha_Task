import java.util.HashMap;
import java.util.Scanner;

public class AIChatbot {

    private static HashMap<String, String> responses = new HashMap<>();

    public static void main(String[] args) {
        initializeResponses();
        Scanner scanner = new Scanner(System.in);
        System.out.println("AI Chatbot: Hello! How can I help you today? (type 'exit' to quit)");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("AI Chatbot: Goodbye!");
                break;
            }

            String response = getResponse(input);
            System.out.println("AI Chatbot: " + response);
        }

        scanner.close();
    }

    private static void initializeResponses() {
        responses.put("hello", "Hi there!");
        responses.put("hi", "Hello! How can I assist you?");
        responses.put("how are you", "I'm just a bot, but I'm doing fine. Thanks!");
        responses.put("what is your name", "I'm your AI Chatbot.");
        responses.put("bye", "Goodbye! Have a great day.");
        responses.put("help", "Sure, I'm here to help. Ask me anything.");
    }

    private static String getResponse(String input) {
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }
        return "I'm sorry, I didn't understand that. Can you please rephrase?";
    }
}
