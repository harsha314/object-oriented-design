# Problem Statements for Practice

## Creational Design Patterns

#### Singleton

The **Singleton** pattern ensures a class has only one instance and provides a global access point to it.

1.  **Problem 1: Logger System** 📝

    - **Functional Requirements:** The system needs a single logging instance to write messages to a file. Multiple parts of the application should be able to access this single instance to ensure all log messages are written in a sequential and centralized manner. It must prevent multiple logger instances from being created accidentally.

2.  **Problem 2: Database Connection Pool** 🔗
    - **Functional Requirements:** An application needs a connection pool to manage connections to a database. To avoid resource contention and overhead from creating multiple pools, there should be only one instance of the connection pool class accessible throughout the application.

---

#### Factory Method

The **Factory Method** pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate.

1.  **Problem 1: Document Processing System** 📄

    - **Functional Requirements:** An application needs to process different types of documents (e.g., PDF, Word). The system should have a `Document` interface. A `DocumentCreator` class defines a factory method to create a `Document` object. Subclasses like `PdfCreator` and `WordCreator` will override this method to return the specific type of document object required.

2.  **Problem 2: Logistics and Transport** 🚚
    - **Functional Requirements:** A logistics application must be able to plan deliveries using different modes of transport, such as trucks and ships. The system needs a `Transport` interface with a `deliver()` method. A `Logistics` superclass will have a factory method `createTransport()` that is implemented by subclasses (`RoadLogistics`, `SeaLogistics`) to produce the correct `Transport` object for a given delivery.

---

#### Abstract Factory

The **Abstract Factory** pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

1.  **Problem 1: UI Toolkit** 🖥️

    - **Functional Requirements:** A cross-platform UI application needs to create sets of UI components (e.g., buttons, checkboxes) that look and behave consistently for different operating systems (Windows, macOS). The system needs an `AbstractFactory` interface for creating these components. Concrete factories, such as `WindowsFactory` and `MacFactory`, will produce the appropriate `WindowsButton`, `MacButton`, `WindowsCheckbox`, and `MacCheckbox` objects.

2.  **Problem 2: Furniture Shop** 🛋️
    - **Functional Requirements:** An online furniture store needs to offer different collections of furniture (e.g., Modern, Victorian). A customer should be able to choose a collection and receive a set of related furniture pieces (chairs, tables) that all belong to that style. The system should use an abstract factory to create a family of products (chair and table) that share a common theme without exposing the concrete classes.

---

#### Builder

The **Builder** pattern lets you construct complex objects step by step. It allows you to produce different types and representations of an object using the same construction code.

1.  **Problem 1: Computer Assembly** 💻

    - **Functional Requirements:** A computer assembly program needs to create different configurations of computers (e.g., a gaming PC, a business workstation). These configurations have varying parts (CPU, RAM, GPU, storage). The system must allow the step-by-step construction of a computer object, ensuring that the same construction process can build different models without changing the client code.

2.  **Problem 2: Pizza Ordering System** 🍕
    - **Functional Requirements:** A pizza restaurant's ordering system needs to build complex pizza objects with various toppings, crusts, and sauces. Customers should be able to specify optional ingredients and build their pizza piece by piece. The system needs to ensure that the pizza object is not available to the client until it's fully constructed.

---

#### Prototype

The **Prototype** pattern lets you copy existing objects without making your code dependent on their classes.

1.  **Problem 1: Game Character Cloning** 🤖

    - **Functional Requirements:** In a video game, there's a need to create many identical or very similar non-player characters (NPCs) with complex properties. Creating each NPC from scratch is resource-intensive. The system should create a "prototype" NPC and then clone it to quickly generate new characters, modifying only a few properties (e.g., position, name) on the cloned objects.

2.  **Problem 2: Report Generation** 📊
    - **Functional Requirements:** A business application needs to generate many reports that are based on a template. Creating a new report from the template's data every time is slow. The system should maintain a master template object and use a cloning mechanism to create new report instances quickly. The new reports can then be populated with specific data.

## Structural Design Patterns

#### Adapter

The **Adapter** pattern allows objects with incompatible interfaces to collaborate. It acts as a wrapper around an object, making it compatible with a new interface.

1.  **Problem 1: Legacy E-commerce System** 🛍️

    - **Functional Requirements:** An e-commerce platform needs to integrate with a new payment gateway. The legacy system's payment processing interface, `OldPaymentProcessor`, has a different method signature than the new gateway's API, `NewGatewayAPI`. An `Adapter` class is needed to convert the `OldPaymentProcessor` calls into `NewGatewayAPI` calls so the existing code can use the new gateway without modification.

2.  **Problem 2: Media Player** 🎶
    - **Functional Requirements:** A media player application can only play `.mp3` files. The user wants to add support for `.wav` files without changing the main player code. An `AudioAdapter` is required to convert a `WavPlayer` object's interface so that it can be used by the `MediaPlayer` class, which expects the `Mp3Player` interface.

---

#### Bridge

The **Bridge** pattern decouples an abstraction from its implementation so that the two can vary independently.

1.  **Problem 1: Device Controller** 🎮

    - **Functional Requirements:** An application needs to control various devices (e.g., TV, stereo) using different remote controls (e.g., basic, advanced). The system should separate the `Remote` abstraction from the `Device` implementation. This allows new remotes and devices to be added independently of each other. For example, a `BasicRemote` can control a `TV` or a `Stereo`, and an `AdvancedRemote` can also control both.

2.  **Problem 2: Shape Rendering** 🖼️
    - **Functional Requirements:** A drawing program needs to render various shapes (e.g., `Circle`, `Square`) using different rendering APIs (e.g., `OpenGL`, `DirectX`). The system must be designed so that new shapes and new rendering APIs can be introduced without affecting each other. The `Shape` class should contain a reference to a `DrawingAPI` object, and a `Circle` object can be drawn using either the `OpenGLAPI` or the `DirectXAPI`.

---

#### Composite

The **Composite** pattern composes objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

1.  **Problem 1: File System** 📁

    - **Functional Requirements:** An application needs to represent a file system, which contains both individual files and folders (directories) that can contain other files and folders. The system must be able to perform operations (e.g., `getSize()`) on both individual files and entire directories uniformly. A `FileSystemComponent` interface will be implemented by both `File` and `Directory` classes, with the `Directory` class holding a collection of `FileSystemComponent` objects.

2.  **Problem 2: Organizational Hierarchy** 🏢
    - **Functional Requirements:** A company's organizational chart needs to be represented. The system must handle individual employees as well as departments, which are collections of employees or other departments. Operations like `displayInfo()` should work seamlessly for both a single employee and an entire department.

---

#### Decorator

The **Decorator** pattern attaches new responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

1.  **Problem 1: Coffee Shop Order** ☕

    - **Functional Requirements:** A coffee shop ordering system needs to calculate the price of a coffee with different add-ons (e.g., milk, sugar, whipped cream). The base `Coffee` object has a cost. `Decorator` classes like `MilkDecorator` and `SugarDecorator` should wrap the `Coffee` object to add their costs and descriptions to the final order dynamically.

2.  **Problem 2: Text Editor Formatting** ✍️
    - **Functional Requirements:** A text editor needs to apply various formatting styles (e.g., bold, italic, underline) to text. The system should allow the user to combine these styles on a single `Text` object. `Decorator` classes will wrap the base `Text` object, adding new functionality without modifying the original class.

---

#### Facade

The **Facade** pattern provides a simplified interface to a complex subsystem. It hides the complexity of a system from the client.

1.  **Problem 1: Home Theater System** 🎬

    - **Functional Requirements:** A home automation application needs a simple way to control a complex home theater system. The system consists of multiple components (e.g., DVD player, projector, sound system). A `HomeTheaterFacade` is required to provide a single `watchMovie()` method that handles all the underlying complexity, such as turning on the projector, turning on the sound system, and starting the DVD player.

2.  **Problem 2: Compiler Subsystem** ⚙️
    - **Functional Requirements:** A compiler application has complex subsystems for parsing, tokenizing, and generating code. A client programmer should not need to interact with these individual components directly. A `CompilerFacade` should provide a single `compile(file)` method that orchestrates all the necessary steps in the correct order, hiding the internal complexity of the compiler.

---

#### Flyweight

The **Flyweight** pattern minimizes memory usage by sharing as much data as possible with similar objects. It's used when a large number of objects are needed.

1.  **Problem 1: Character Formatting in a Document** 📝

    - **Functional Requirements:** A word processing application needs to display millions of characters on a page. Each character object should not store its font, color, and size individually, as these properties are often shared among many characters. A `FlyweightFactory` should store and reuse these intrinsic, shared properties. Each character object would then only store its extrinsic, unique property (its position on the page).

2.  **Problem 2: Tree Rendering in a Game** 🌳
    - **Functional Requirements:** A game needs to render thousands of trees in a forest. The trees are identical in appearance (mesh, texture) but have unique positions on the map. The system must create a single `TreeFlyweight` object for the shared tree data and then use this flyweight to render each tree at its unique position, conserving memory.

---

#### Proxy

The **Proxy** pattern provides a surrogate or placeholder for another object to control access to it.

1.  **Problem 1: Image Loading** 🖼️

    - **Functional Requirements:** A photo album application needs to display a large collection of high-resolution images. Loading all images at once is slow and memory-intensive. A `Proxy` object should be used to stand in for the real `Image` object. The proxy will only load the actual image file from disk when it is needed for display, improving performance.

2.  **Problem 2: Access Control to Sensitive Data** 🔒
    - **Functional Requirements:** An application needs to access a database with sensitive user information. Not all users should have access to this data. A `Proxy` class for the `Database` object is needed to perform access checks. Before delegating a request to the real `Database` object, the `Proxy` will verify the user's permissions.

## Behavioral Design Patterns

#### Chain of Responsibility

The **Chain of Responsibility** pattern lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

1.  **Problem 1: Help Desk Ticket System** 🎫

    - **Functional Requirements:** An online help desk system needs to handle support tickets. Tickets can be simple (tier 1), moderately complex (tier 2), or very complex (tier 3). The system should automatically forward a ticket to the next level of support if the current one cannot resolve it, without the client needing to know which handler will solve the problem.

2.  **Problem 2: Purchase Approval Workflow** 💲
    - **Functional Requirements:** A company's internal purchasing system requires different levels of approval based on the cost of the item. A manager can approve purchases up to $1000, a director up to $5000, and a vice president for any amount above that. The system should process a purchase request by checking each approval level in a sequence until the request is handled.

---

#### Command

The **Command** pattern turns a request into a stand-alone object that contains all information about the request. This allows you to parameterize clients with different requests, queue or log requests, and support undoable operations.

1.  **Problem 1: Text Editor** ✍️

    - **Functional Requirements:** A text editor needs to support actions like `copy`, `paste`, and `undo`. Each action should be encapsulated as a `Command` object. This allows the editor to maintain a history of commands, enabling the user to easily revert to a previous state using the `undo` functionality.

2.  **Problem 2: Remote Control for Smart Devices** 🏠
    - **Functional Requirements:** A universal remote control needs to issue commands to various smart devices (e.g., `TurnOnTV`, `OpenGarageDoor`). Each command should be an object that can be stored in a queue. The remote should have a single `execute()` method that can trigger any of these commands without knowing the specific details of the device.

---

#### Iterator

The **Iterator** pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

1.  **Problem 1: Custom Collection Traversal** 🗄️

    - **Functional Requirements:** An application has a custom-built collection class, `CustomList`, which stores elements in a unique way. Users of this collection need to be able to loop through all its elements without having to know how the list is internally structured. An `Iterator` class is needed to provide a standardized `hasNext()` and `next()` interface for traversal.

2.  **Problem 2: Social Media Feed** 📱
    - **Functional Requirements:** A social media application needs to display a user's feed, which consists of posts from various sources. The feed should be viewed sequentially. An `Iterator` is required to traverse the feed posts one by one, regardless of whether the posts are stored in an array, a linked list, or a database query result.

---

#### Mediator

The **Mediator** pattern lets you reduce chaotic dependencies between objects. It restricts direct communication between the objects and forces them to collaborate only via a mediator object.

1.  **Problem 1: Flight Control Tower** ✈️

    - **Functional Requirements:** In an air traffic control system, many planes are flying in the same airspace. A `Plane` object should not communicate directly with other `Plane` objects. A central `AirTrafficMediator` is needed to handle all communication and coordinate takeoffs, landings, and flight paths to prevent collisions.

2.  **Problem 2: GUI Component Interaction** 🖥️
    - **Functional Requirements:** A graphical user interface has multiple components like buttons, checkboxes, and text fields that interact with each other. For example, a "submit" button might be enabled only when a checkbox is ticked and a text field has been filled. A `Mediator` class is needed to manage these complex interactions, so the individual GUI components don't have to know about each other.

---

#### Memento

The **Memento** pattern lets you save and restore the previous state of an object without revealing the details of its implementation.

1.  **Problem 1: Calculator Application** ➕

    - **Functional Requirements:** A simple calculator application needs an "undo" feature. The system should be able to save the state of the calculator (the current number and operation) at any point. When the user clicks "undo," the calculator must revert to the previously saved state.

2.  **Problem 2: Text Editor History** 📝
    - **Functional Requirements:** A text editor needs to save the history of changes made to a document. A `Document` object's state (the text content) needs to be stored in a `Memento` object. This allows the user to restore the document to any previous state from the history list.

---

#### Observer

The **Observer** pattern defines a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.

1.  **Problem 1: Stock Market Application** 📈

    - **Functional Requirements:** A stock market application needs to notify multiple users when the price of a specific stock changes. The stock (`Subject`) should maintain a list of users (`Observers`) who are interested in its price. When the stock's price is updated, it automatically notifies all subscribed users.

2.  **Problem 2: Social Media Notifications** 🔔
    - **Functional Requirements:** On a social media platform, when a user posts a new photo, all of their followers should receive a notification. The user's profile is the `Subject`, and the followers are the `Observers`. The `Subject` should notify all `Observers` whenever a new post is made.

---

#### State

The **State** pattern lets an object alter its behavior when its internal state changes. The object will appear to change its class.

1.  **Problem 1: Vending Machine** 🥤

    - **Functional Requirements:** A vending machine has different states (e.g., `NoCoinState`, `HasCoinState`, `SoldState`). The behavior of the vending machine (e.g., what happens when the `insertCoin()` or `selectItem()` buttons are pressed) depends on its current state. The system should use a separate class for each state, and the vending machine object should delegate its behavior to the current state object.

2.  **Problem 2: Traffic Light** 🚦
    - **Functional Requirements:** A traffic light cycles through different states: `Red`, `Yellow`, and `Green`. The system must ensure that the traffic light's behavior (e.g., what happens when a timer expires) is determined by its current color state. A `TrafficLight` object will hold a reference to its current state, which will be one of the concrete `State` objects.

---

#### Strategy

The **Strategy** pattern lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

1.  **Problem 1: Sorting Algorithms** 🔢

    - **Functional Requirements:** An application needs to sort a list of data using different algorithms (e.g., `QuickSort`, `MergeSort`). The sorting behavior should be selectable at runtime. A `Context` class holds a reference to a `Strategy` object. The `Context` will use the `Strategy` to sort the data, and the user can easily switch between different sorting strategies without changing the core `Context` class.

2.  **Problem 2: Shipping Cost Calculation** 📦
    - **Functional Requirements:** An e-commerce platform needs to calculate shipping costs for orders. The cost calculation varies based on the shipping method chosen by the user (e.g., `StandardShipping`, `ExpressShipping`). Each shipping method should be a separate `Strategy`, and the `Order` class should be able to apply the correct shipping strategy to determine the final cost.

---

#### Template Method

The **Template Method** pattern defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

1.  **Problem 1: Online Game AI** 🎮

    - **Functional Requirements:** A video game needs to implement AI for different types of characters (e.g., `Warrior`, `Mage`). The overall algorithm for their turn is the same (`prepare`, `act`, `endTurn`), but the specific actions in each step differ. A `CharacterAI` abstract class will define the `templateMethod()` for the turn, and subclasses will provide concrete implementations for the `act()` step.

2.  **Problem 2: Report Generation** 📄
    - **Functional Requirements:** A business application needs to generate various types of reports (e.g., `PDFReport`, `CSVReport`). The overall process for generating a report is always the same (`createHeader`, `createBody`, `createFooter`), but the implementation of each step is different for each file format. A `ReportGenerator` abstract class will define the template method, and subclasses will override the specific methods to produce their unique output.

---

#### Visitor

The **Visitor** pattern lets you separate an algorithm from an object structure on which it operates. This allows you to add new operations to an object structure without modifying the structure itself.

1.  **Problem 1: XML Document Processing** 🌐

    - **Functional Requirements:** An application needs to perform different operations (e.g., `exportToText`, `calculateSize`) on a complex `XMLNode` structure. It's not desirable to add new methods to the `XMLNode` classes for every new operation. A `Visitor` pattern is needed to provide a new operation via a `Visitor` object that traverses the `XMLNode` hierarchy.

2.  **Problem 2: Company Employee Hierarchy** 🧑‍💼
    - **Functional Requirements:** A company has an employee hierarchy consisting of `Manager`, `Developer`, and `Intern` objects. The system needs to be able to perform various reports on this hierarchy (e.g., `calculateTotalSalary`, `printPerformanceReviews`). A `Visitor` pattern is required to add these new operations without modifying the employee classes themselves. For instance, a `SalaryVisitor` would be able to traverse the entire hierarchy and calculate the total salary.
