package solid;

/**
 * Dependency Inversion Principle
 * High level modules should not directly depend on low level modules, instead they should depend on abstractions.
 */

// Application Layer - High Level Module
class MyMessenger {
    TCPProtocolHandler tcpProtocolHandler = new TCPProtocolHandler();

    public void send(String to, String messsage) {
        tcpProtocolHandler.sendMessage("Message to " + to + ", message " + messsage);
    }
}

// Transport Layer - Low Level Module
class TCPProtocolHandler {
    public void sendMessage(String message) {
        System.out.println("TCPProtocolHandler Sending Message: " + message);
    }
}

// Dependency Inversion Principle:
interface ProtocolHandler {
    void sendMessage(String message);
}

// Transport Layer - Low Level Module
class TCPProtocolHandler1 implements ProtocolHandler {
    public void sendMessage(String message) {
        System.out.println("TCPProtocolHandler Sending Message: " + message);
    }
}

class UDPProtocolHandler1 implements ProtocolHandler {
    public void sendMessage(String message) {
        System.out.println("UPDProtocolHandler Sending Message: " + message);
    }
}

// Application Layer - High Level Module
class MyMessenger1 {
    ProtocolHandler protocolHandler;

    public MyMessenger1(String protocol) {
        protocolHandler = ProtocolHandlerFactory.getProtocolHandler(protocol);
    }

    public void send(String to, String messsage) {
        protocolHandler.sendMessage("Message to " + to + ", message " + messsage);
    }
}

class ProtocolHandlerFactory {
    public static ProtocolHandler getProtocolHandler(String protocol) {
        if ("TCP".equalsIgnoreCase(protocol)) {
            return new TCPProtocolHandler1();
        }
        if ("UDP".equalsIgnoreCase(protocol)) {
            return new UDPProtocolHandler1();
        }

        return null;
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        MyMessenger messenger = new MyMessenger();
        messenger.send("Tom", "Hello World!!!");

        MyMessenger1 messenger1 = new MyMessenger1("UDP");
        messenger1.send("Holland", "Hello World!!!");
    }
}
