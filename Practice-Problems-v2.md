# Object-Oriented Design Interview Problems - Complete Requirements

## Table of Contents

1. [CRUD Applications](#crud-applications)
2. [Games](#games)
3. [Library Implementations](#library-implementations)
4. [System Design Components](#system-design-components)
5. [Hierarchical Structures](#hierarchical-structures)
6. [Workflow/State Machines](#workflowstate-machines)
7. [Additional Categories](#additional-categories)

---

## CRUD Applications

### 1. Parking Lot System

**Requirements:**

- Support multiple floors, each with multiple parking spots
- Three types of spots: Compact, Large, Handicapped
- Four types of vehicles: Motorcycle, Car, SUV, Bus
  - Motorcycle: can park in any spot
  - Car: can park in Compact or Large
  - SUV: can park in Large only
  - Bus: requires 5 consecutive Large spots
- Track entry/exit times for each vehicle
- Calculate parking fee based on duration (hourly rate varies by spot type)
- Display available spots per floor and type
- Generate parking ticket with spot location on entry
- Process payment and release vehicle on exit
- Handle full parking lot scenario
- Support finding nearest available spot for a vehicle

---

### 2. Hotel Booking System

**Requirements:**

- Multiple hotels, each with multiple rooms
- Room types: Single, Double, Suite, Deluxe
- Each room has: room number, floor, price per night, amenities
- Guest can search available rooms by:
  - Date range (check-in/check-out)
  - Room type
  - Price range
  - Location/hotel
- Booking operations:
  - Create reservation (holds room)
  - Confirm booking with payment
  - Cancel booking (refund policy based on cancellation time)
  - Modify booking (dates, room type)
- Handle overbooking scenarios
- Support multiple guests per room
- Track room status: Available, Reserved, Occupied, Maintenance
- Guest services: early check-in, late checkout (extra charges)
- Payment processing: full payment, partial payment, payment at checkout
- Generate invoice with itemized charges
- Support loyalty programs (discounts for repeat customers)
- Housekeeping integration (room cleaning status)
- Prevent double booking of same room for overlapping dates

---

### 3. Library Management System

**Requirements:**

- Manage books, magazines, newspapers
- Book attributes: ISBN, title, author, publisher, category, copies available
- Member management: member ID, name, contact, membership type
- Membership types: Student, Faculty, Public (different borrowing limits)
- Operations:
  - Issue book to member
  - Return book
  - Renew book (if no reservations pending)
  - Reserve book (if all copies issued)
  - Search books by title, author, ISBN, category
- Borrowing rules:
  - Students: 5 books max, 14 days
  - Faculty: 10 books max, 30 days
  - Public: 3 books max, 7 days
- Fine calculation for overdue books (per day)
- Handle lost books (charge replacement cost + processing fee)
- Track book history (who borrowed when)
- Send reminders for due dates
- Handle reservation queue (FIFO when book returned)
- Librarian operations:
  - Add/remove books from catalog
  - Register new members
  - Block/unblock members (for excessive fines)
- Generate reports: most borrowed books, overdue books, member activity

---

## Games

### 4. Chess

**Requirements:**

- Standard 8x8 board with proper initial piece placement
- Support two players (White and Black)
- Implement all piece movement rules (Pawn, Rook, Knight, Bishop, Queen, King)
- Special moves: Castling, En Passant, Pawn Promotion
- Detect check, checkmate, and stalemate
- Validate all moves (can't move into check, must move out of check)
- Track move history for the game
- Support undo/redo of moves
- Detect draw conditions (insufficient material, threefold repetition, 50-move rule)
- Handle turn management (alternating players)
- Optionally support game save/load
- Display current board state

---

### 5. Tic-Tac-Toe

**Requirements:**

- 3x3 grid board
- Two players: X and O
- Players alternate turns
- Valid move: place symbol in empty cell
- Win conditions:
  - Three in a row (horizontal)
  - Three in a column (vertical)
  - Three in diagonal
- Draw condition: board full with no winner
- Display current board state after each move
- Validate moves (prevent overwriting occupied cells)
- Track game statistics (wins, losses, draws per player)
- Support different board sizes (N x N) - extensible
- Support different win conditions (K in a row on N x N board)
- AI player modes:
  - Easy: random valid move
  - Medium: block opponent's winning move
  - Hard: minimax algorithm
- Replay game from move history
- Support player vs player, player vs AI, AI vs AI modes

---

### 6. Snake Game

**Requirements:**

- Grid-based board (configurable size)
- Snake starts with length 3 at center
- Snake moves continuously in current direction
- Control: change direction (up, down, left, right)
- Cannot reverse direction (can't go down if moving up)
- Food appears at random empty positions
- Eating food:
  - Snake grows by 1 unit
  - Score increases
  - New food spawns
- Game over conditions:
  - Snake hits wall (or allow wrapping for easier mode)
  - Snake collides with itself
- Speed increases as snake grows (optional)
- Display current score and high score
- Pause/resume game
- Different difficulty levels:
  - Easy: slower speed, walls wrap
  - Medium: moderate speed, walls are barriers
  - Hard: fast speed, obstacles on board
- Power-ups (optional):
  - Slow down time temporarily
  - Pass through walls once
  - Double points for limited time
- Track game statistics: games played, high score, average score

---

### 7. Blackjack

**Requirements:**

- Standard 52-card deck (support multiple decks)
- Player vs Dealer game
- Card values:
  - Number cards: face value
  - Face cards (J, Q, K): 10
  - Ace: 1 or 11 (player's choice/automatic best)
- Game flow:
  - Players place bets
  - Deal 2 cards to player, 2 to dealer (1 face up, 1 face down)
  - Player actions: Hit, Stand, Double Down, Split
  - Dealer reveals hidden card after player stands
  - Dealer must hit on 16 or less, stand on 17 or more
- Win conditions:
  - Blackjack (21 with 2 cards): pays 3:2
  - Player closer to 21 than dealer: pays 1:1
  - Bust (over 21): player loses bet
  - Push (tie): return bet
- Split rules:
  - Only on matching cards
  - Creates two hands, requires additional bet
  - Can hit each hand independently
- Double down:
  - Double bet, receive exactly one more card
  - Only allowed on initial two cards
- Insurance (when dealer shows Ace)
- Track player bankroll (starting chips, current chips)
- Handle multiple players at same table
- Shuffle deck when running low on cards
- Detect card counting (optional challenge)

---

## Library Implementations

### 8. LRU Cache

**Requirements:**

- Support get(key) and put(key, value) operations
- Both operations should be O(1) average time complexity
- Fixed capacity specified at creation
- When capacity is reached, evict least recently used item
- "Used" means either accessed (get) or added/updated (put)
- Thread-safe operations (multiple threads can access simultaneously)
- Support generic key-value types
- Optional: Support TTL (time-to-live) per entry
- Optional: Support different eviction policies (LRU, LFU, FIFO) - make it extensible
- Handle null keys/values appropriately
- Provide size() and clear() methods

---

### 9. Rate Limiter

**Requirements:**

- Limit number of requests per user/IP in a time window
- Support multiple algorithms:
  - **Token Bucket**: refill N tokens per second, max capacity M
  - **Leaky Bucket**: process requests at fixed rate, queue overflow
  - **Fixed Window**: N requests per fixed time window (e.g., per minute)
  - **Sliding Window Log**: track timestamps of each request
  - **Sliding Window Counter**: combine fixed windows with weighted counts
- Operations:
  - `allowRequest(userId)`: returns true/false
  - `getRemainingTokens(userId)`: check current quota
  - `resetLimit(userId)`: admin operation to reset
- Support different limits for different users/tiers:
  - Free tier: 100 requests/hour
  - Premium: 1000 requests/hour
  - Enterprise: unlimited
- Thread-safe for concurrent requests
- Distributed system support (multiple servers need shared state)
- Handle clock skew in distributed environment
- Configurable: rate, window size, burst capacity
- Low memory footprint (cleanup expired entries)
- Return retry-after time when rate limited
- Track violation attempts for security monitoring

---

### 10. Thread Pool

**Requirements:**

- Fixed number of worker threads
- Task queue for pending tasks
- Operations:
  - `submit(task)`: add task to queue
  - `shutdown()`: stop accepting new tasks, finish existing
  - `shutdownNow()`: interrupt running tasks immediately
- Worker threads:
  - Wait for tasks from queue
  - Execute tasks
  - Return to pool when done
- Queue strategies:
  - Bounded queue (fixed capacity)
  - Unbounded queue (may cause memory issues)
  - Priority queue (tasks have priority)
- Rejection policies when queue is full:
  - AbortPolicy: throw exception
  - CallerRunsPolicy: execute in caller's thread
  - DiscardPolicy: silently discard task
  - DiscardOldestPolicy: remove oldest, add new
- Support task priorities
- Handle task exceptions gracefully (don't kill worker thread)
- Provide statistics:
  - Active thread count
  - Completed task count
  - Queue size
  - Average task execution time
- Support scheduled execution (delay, periodic)
- Configurable:
  - Core pool size
  - Maximum pool size
  - Keep-alive time for idle threads
  - Queue capacity
- Thread factory for custom thread creation
- Support task cancellation (Future pattern)

---

### 11. Message Queue

**Requirements:**

- FIFO queue for messages between producers and consumers
- Support multiple producers and consumers
- Operations:
  - `send(message, queue)`: producer adds message
  - `receive(queue)`: consumer retrieves message
  - `acknowledge(messageId)`: confirm processing
  - `peek(queue)`: view message without removing
- Message attributes:
  - ID, payload, timestamp, priority, TTL
- Queue types:
  - Standard: at-least-once delivery
  - FIFO: exactly-once, ordered delivery
  - Priority: high-priority messages first
- Dead letter queue:
  - Messages that fail processing repeatedly
  - Configurable max retry count
- Message visibility timeout:
  - Hide message from other consumers while processing
  - Re-queue if not acknowledged in time
- Durability:
  - Persist messages to disk
  - Survive system crashes
- Topic-based routing (pub-sub):
  - Producers publish to topics
  - Consumers subscribe to topics
- Message filtering:
  - Consumers filter by attributes/headers
- Flow control:
  - Backpressure when consumers slow
  - Rate limiting on producers
- Support batching:
  - Send/receive multiple messages at once
- Monitoring:
  - Queue depth
  - Message age
  - Consumer lag
- Support delayed messages (schedule delivery)

---

## System Design Components

### 12. Task Scheduler

**Requirements:**

- Schedule tasks to run at specific times or after delays
- Support one-time and recurring tasks
- Recurring tasks: fixed rate vs fixed delay
  - Fixed rate: run every N seconds regardless of execution time
  - Fixed delay: wait N seconds after previous execution completes
- Support task priorities (high, medium, low)
- Execute tasks using a thread pool (configurable size)
- Cancel scheduled tasks before execution
- Handle task failures (retry logic, dead letter queue)
- Prevent concurrent execution of same recurring task
- Support task dependencies (task B runs only after task A completes)
- Graceful shutdown: wait for running tasks, cancel pending ones
- Provide task status (scheduled, running, completed, failed, cancelled)
- Optional: Persist tasks to survive system restarts

---

### 13. Pub-Sub System

**Requirements:**

- Publishers send messages to topics
- Subscribers receive messages from topics they're subscribed to
- Operations:
  - `createTopic(name)`
  - `deleteTopic(name)`
  - `publish(topic, message)`
  - `subscribe(topic, subscriber)`
  - `unsubscribe(topic, subscriber)`
- Message delivery:
  - Push model: system delivers to subscribers
  - Pull model: subscribers poll for messages
- Message ordering:
  - No ordering guarantee (default)
  - FIFO ordering per topic (optional)
- Subscription types:
  - Exclusive: only one subscriber receives message
  - Shared: load balance across multiple subscribers
  - Broadcast: all subscribers receive message
- Message filtering:
  - Subscribers filter by message attributes
  - Topic wildcards (subscribe to pattern)
- Delivery guarantees:
  - At-most-once: fire and forget
  - At-least-once: retry until acknowledged
  - Exactly-once: deduplication
- Handle slow subscribers:
  - Queue messages up to limit
  - Drop messages or disconnect subscriber
- Message persistence:
  - In-memory only (fast, volatile)
  - Disk-backed (durable, slower)
- Message TTL (expire old messages)
- Replay capability: reprocess old messages
- Dead letter handling for failed deliveries
- Support hierarchical topics: `sensors/temperature/room1`
- Authentication & authorization per topic
- Metrics: message rate, subscriber count, delivery latency

---

### 14. Notification Service

**Requirements:**

- Send notifications through multiple channels:
  - Email
  - SMS
  - Push notifications (mobile)
  - In-app notifications
  - Webhooks
- User preferences:
  - Enable/disable per channel
  - Quiet hours (no notifications during time range)
  - Frequency caps (max N per hour)
- Notification types:
  - Transactional (always sent): password reset, order confirmation
  - Marketing (respect preferences): promotions, newsletters
  - Alerts (urgent): security alerts, critical updates
- Operations:
  - `send(userId, notification, channels)`: send to user
  - `sendBulk(userIds, notification)`: batch sending
  - `scheduleNotification(userId, notification, time)`: delayed send
  - `cancelNotification(notificationId)`: cancel scheduled
- Template management:
  - Store templates with variables
  - Render templates with user data
  - Support multiple languages
- Priority levels:
  - High: send immediately
  - Medium: batch and send
  - Low: aggregate daily digest
- Retry logic:
  - Retry failed deliveries with exponential backoff
  - Max retry attempts
  - Dead letter queue for permanent failures
- Delivery tracking:
  - Sent, delivered, read, clicked
  - Failure reasons
- Rate limiting:
  - Per user (prevent spam)
  - Per channel (respect provider limits)
- Unsubscribe handling:
  - One-click unsubscribe from emails
  - Global unsubscribe option
- A/B testing support (send variants)
- Analytics:
  - Delivery rates per channel
  - Open/click rates
  - User engagement metrics
- Handle channel-specific requirements:
  - Email: subject, body, attachments
  - SMS: character limits, short links
  - Push: title, body, icon, action buttons

---

## Hierarchical Structures

### 15. In-Memory File System

**Requirements:**

- Support directories and files in a tree structure
- Operations:
  - `mkdir(path)`: Create directory (create parent dirs if needed)
  - `addFile(path, content)`: Create/update file
  - `readFile(path)`: Return file content
  - `ls(path)`: List contents of directory (or show file name if path is file)
  - `rm(path)`: Delete file/directory recursively
  - `mv(source, dest)`: Move/rename file or directory
  - `cp(source, dest)`: Copy file or directory
- Support both absolute paths (/home/user/file.txt) and relative paths
- Handle invalid paths gracefully
- Track metadata: creation time, modification time, size
- Support file permissions (read, write, execute) per user
- Calculate total size of directory (including subdirectories)
- Find all files matching a pattern (simple wildcard search)
- Prevent cyclic references in directory structure

---

### 16. Organization Chart

**Requirements:**

- Tree structure representing company hierarchy
- Employee attributes: ID, name, title, department, salary, hire date
- Each employee has one manager (except CEO)
- Manager can have multiple direct reports
- Operations:
  - `addEmployee(employee, managerId)`: add to organization
  - `removeEmployee(employeeId)`: remove and reassign reports
  - `changeManager(employeeId, newManagerId)`: transfer employee
  - `getDirectReports(managerId)`: immediate subordinates
  - `getAllReports(managerId)`: all subordinates recursively
  - `getManagerChain(employeeId)`: path to CEO
  - `getCommonManager(emp1, emp2)`: lowest common ancestor
- Calculate organization metrics:
  - Total employees under manager (span of control)
  - Organization depth (levels from CEO)
  - Average team size per manager
  - Department headcount
- Salary operations:
  - Calculate total salary budget for a manager's org
  - Find employees within salary range
  - Compare salary to market/peers
- Search operations:
  - Find employees by title, department, name
  - Find all managers
  - Find employees hired in date range
- Prevent cycles (employee can't be their own ancestor)
- Handle reorganizations (move entire subtree)
- Support dotted-line reporting (multiple managers)
- Track historical changes (who reported to whom when)
- Generate org chart visualization (tree representation)
- Support matrix organizations (project + functional reporting)

---

### 17. Expression Evaluator (AST - Abstract Syntax Tree)

**Requirements:**

- Parse mathematical expressions into tree structure
- Support operations: +, -, \*, /, ^(power), %(modulo)
- Support parentheses for precedence
- Support variables: `x + 2 * y`
- Operations:
  - `parse(expression)`: string to AST
  - `evaluate(variables)`: calculate result
  - `toString()`: convert AST back to string
  - `simplify()`: algebraic simplification
  - `derivative(variable)`: symbolic differentiation
- Node types:
  - NumberNode: constants
  - VariableNode: variables (x, y, z)
  - OperatorNode: binary operations
  - UnaryNode: negation, functions
  - FunctionNode: sin, cos, log, etc.
- Operator precedence:
  - Parentheses (highest)
  - Power (^)
  - Multiplication, Division, Modulo
  - Addition, Subtraction (lowest)
- Associativity:
  - Left-to-right: +, -, \*, /
  - Right-to-left: ^
- Handle errors:
  - Syntax errors (unmatched parentheses)
  - Division by zero
  - Undefined variables
- Simplification rules:
  - `x + 0 = x`
  - `x * 1 = x`
  - `x * 0 = 0`
  - `x - x = 0`
  - Constant folding: `2 + 3 = 5`
- Support comparison operators: <, >, <=, >=, ==, !=
- Support logical operators: AND, OR, NOT
- Tree traversal:
  - In-order: produces expression
  - Post-order: for evaluation
  - Pre-order: for prefix notation

---

## Workflow/State Machines

### 18. Vending Machine

**Requirements:**

- Inventory management for products (name, price, quantity)
- Support multiple product slots/shelves
- Accept coins/bills: quarters (25¢), dollars ($1), five dollars ($5)
- States: Idle, HasMoney, Dispensing, OutOfStock
- User operations:
  - Insert money
  - Select product
  - Request refund/cancel
  - Collect product and change
- Validate sufficient money for selected product
- Dispense product and calculate change
- Return change using minimum number of coins/bills
- Handle insufficient change scenario (cannot complete transaction)
- Handle out-of-stock products
- Prevent product dispensing if door is open
- Admin operations:
  - Restock products
  - Collect money
  - Add change to machine
  - View sales report
- Reset to idle state after transaction completion or timeout

---

### 19. ATM System

**Requirements:**

- User authentication: card number + PIN
- Account types: Checking, Savings
- Operations:
  - Check balance
  - Withdraw cash
  - Deposit cash/check
  - Transfer between accounts
  - Print receipt
- States:
  - Idle: waiting for card
  - CardInserted: waiting for PIN
  - Authenticated: ready for operations
  - ProcessingTransaction: executing operation
  - Dispensing: giving cash/receipt
- Withdrawal rules:
  - Check sufficient balance
  - Check ATM cash availability
  - Withdrawal limits: $500 per transaction, $1000 per day
  - Only dispense bills available in ATM ($20, $50, $100)
  - Minimize number of bills dispensed
- Security:
  - 3 PIN attempts max, then block card
  - Timeout after 30 seconds of inactivity
  - Card retained after blocking
  - Transaction logging for audit
- ATM cash management:
  - Track bills of each denomination
  - Alert when running low
  - Admin operations: refill cash, view logs
- Network operations:
  - Communicate with bank server for account operations
  - Handle network failures gracefully (offline mode)
  - Retry failed transactions
- Multiple account handling:
  - Customer can have multiple accounts
  - Select account for operation
- Transaction fees:
  - Free for same-bank customers
  - Charge fee for other banks
- Receipt printing:
  - Optional for each transaction
  - Show transaction details, balance, date/time
- Handle card capture (when suspicious activity detected)
- Different card types: debit, credit (cash advance)

---

### 20. Elevator System

**Requirements:**

- Multiple elevators in a building
- Multiple floors (ground floor = 0, can have basement floors)
- Elevator capacity: maximum weight and passenger count
- User operations:
  - Press up/down button on floor
  - Select destination floor inside elevator
  - Press emergency button
  - Open/close door buttons
- Elevator states:
  - Idle: stationary, doors closed
  - Moving Up/Down: in motion between floors
  - Stopped: at floor, doors open
  - OutOfService: maintenance mode
- Scheduling algorithm:
  - Assign optimal elevator to request
  - Consider: current floor, direction, passenger count
  - Algorithms to support:
    - FCFS (First Come First Serve)
    - SCAN (elevator keeps going in direction until no more requests)
    - LOOK (like SCAN but reverses at last request, not end)
    - Shortest Seek Time First (nearest request first)
- Direction optimization:
  - Pick up passengers going same direction
  - Don't reverse direction while requests exist in current direction
- Safety features:
  - Door won't close if obstructed
  - Emergency stop button
  - Weight limit enforcement (alarm if exceeded)
  - Maximum floor and minimum floor limits
- Door operations:
  - Stay open for configurable time (e.g., 5 seconds)
  - Close faster if no one entering
  - Reopen if obstruction detected
- Display:
  - Current floor on each floor
  - Current floor inside elevator
  - Direction indicator (up/down arrows)
  - Wait time estimate on floors
- Handle elevator failures:
  - Take elevator out of service
  - Redistribute passengers to other elevators
- Energy optimization:
  - Move idle elevators to strategic floors (e.g., ground floor, or distributed)
- Peak hours handling:
  - Morning: concentrate elevators at ground floor
  - Evening: concentrate at upper floors
- Support express elevators (skip certain floors)
- Support freight elevators (higher capacity, slower)

---

### 21. Traffic Light System

**Requirements:**

- Control lights at an intersection
- Light types:
  - Regular intersection: N-S and E-W roads
  - T-intersection: 3 roads
  - 4-way intersection with turn lanes
- Signal states:
  - Red: stop
  - Yellow: prepare to stop
  - Green: go
- Signal cycle:
  - Green → Yellow → Red (cannot skip)
  - Yellow duration: fixed (e.g., 3 seconds)
  - Green/Red duration: variable based on traffic
- Turn signal handling:
  - Protected left turn (dedicated arrow)
  - Permitted left turn (yield on green)
  - Right turn on red (configurable)
- Pedestrian signals:
  - Walk/Don't Walk signals
  - Countdown timers
  - Request button (may extend walk time)
- Safety constraints:
  - All directions red for brief period during transition (all-red phase)
  - Opposite directions cannot both be green
  - Pedestrian crossing only when traffic is red
  - Minimum green time (prevent too-short cycles)
- Timing strategies:
  - Fixed timing: predetermined schedule
  - Actuated: sensors detect vehicles/pedestrians
  - Adaptive: adjust based on traffic density
- Sensor integration:
  - Loop detectors: count vehicles waiting
  - Cameras: analyze traffic flow
  - Pedestrian buttons: request crossing
- Emergency vehicle preemption:
  - Detect approaching emergency vehicle
  - Give immediate green light in their direction
  - Return to normal operation after passing
- Coordination with adjacent intersections:
  - Green wave: synchronize for continuous flow
  - Offset timing for main corridors
- Handle malfunctions:
  - Default to flashing red (4-way stop)
  - Log failures for maintenance
- Special modes:
  - Late night: flashing yellow on main road, red on side road
  - Maintenance mode: all flashing red
  - Manual override for special events
- Support roundabouts (no signals, yield rules)

---

## Additional Categories

### 22. Ride-Sharing Service (Uber/Lyft-like)

**Requirements:**

- User types: Rider, Driver
- Rider operations:
  - Request ride (pickup location, destination)
  - Choose ride type (economy, premium, XL)
  - View estimated cost and arrival time
  - Cancel ride
  - Rate driver
  - View ride history
- Driver operations:
  - Go online/offline
  - Accept/reject ride requests
  - Navigate to pickup location
  - Start trip (verify rider)
  - Complete trip
  - Rate rider
  - View earnings
- Ride matching algorithm:
  - Find available drivers near rider
  - Consider driver rating, vehicle type
  - Notify closest drivers first
  - Timeout and try next driver if no response
- Fare calculation:
  - Base fare + distance _ rate + time _ rate
  - Surge pricing during high demand
  - Tolls and fees
  - Promotional codes/discounts
- Real-time tracking:
  - Rider sees driver approaching
  - Driver sees route to pickup and destination
  - ETA updates
- Payment processing:
  - Multiple payment methods (card, wallet, cash)
  - Split fare between multiple riders
  - Automatic charging after trip
  - Tip driver option
- Safety features:
  - Share trip details with emergency contact
  - SOS button
  - Verify driver/rider identity (photo, license)
  - Two-way rating system
- Driver availability zones (geofencing)
- Handle ride cancellations:
  - Free cancellation within time window
  - Cancellation fee after window
- Support scheduled rides (book in advance)
- Carpool/shared rides (multiple riders, same direction)
- Driver performance tracking:
  - Acceptance rate
  - Cancellation rate
  - Average rating
  - Deactivate low-performing drivers

---

### 23. Splitwise (Expense Sharing Application)

**Requirements:**

**User Management:**

- User registration with email, phone, name
- User profile with payment methods (UPI, bank account, PayPal)
- Friend connections (add/remove friends)
- User groups (roommates, trips, office lunch, etc.)

**Expense Management:**

- Create expense with:
  - Amount
  - Description
  - Date
  - Payer (who paid)
  - Participants (who owes)
  - Category (food, rent, utilities, entertainment, etc.)
  - Receipt/image attachment (optional)
- Split types:
  - **Equal split**: divide equally among all participants
  - **Exact amounts**: specify exact amount each person owes
  - **Percentages**: split by percentage (e.g., 60-40)
  - **Shares**: split by shares/ratio (e.g., 2:1:1)
  - **By item**: itemized bill splitting (Person A owes for item 1, Person B for item 2)
- Support partial payers: multiple people can contribute to paying an expense
- Edit/delete expenses (with appropriate permissions)
- Recurring expenses (monthly rent, subscriptions)

**Group Management:**

- Create groups with name, description, image
- Add/remove members from groups
- Group types: Home, Trip, Couple, Other
- Group expenses (all members involved by default)
- Group settings:
  - Simplify debts (on/off)
  - Default split method
- Leave group (settle balances first)
- Delete group (creator only, after all settled)

**Balance Tracking:**

- Calculate balances between users:
  - "You owe X to Y: $50"
  - "Y owes you: $30"
  - Net balance with each friend
- Overall balance (total you owe vs total owed to you)
- Group-wise balance breakdown
- Balance history over time

**Settlement/Payment:**

- Record settlement:
  - Who paid whom
  - Amount
  - Date
  - Payment method
  - Note/reference
- Mark as "settled up" between users
- Partial settlements (pay portion of debt)
- Settlement suggestions (optimal payment flow)
- Integration with payment gateways (optional)

**Debt Simplification:**

- Minimize number of transactions in a group
- Example: If A owes B $10, B owes C $10 → Simplify to A owes C $10
- Algorithm to reduce total transactions:
  - Find optimal payment graph
  - Minimize number of settlements needed
- Apply simplification at group level or globally

**Activity Feed:**

- Show recent activity:
  - Expenses added
  - Payments made
  - Comments on expenses
- Filter by date, person, group
- Notifications for:
  - Added to expense
  - Payment received
  - Expense edited/deleted
  - Reminders for unsettled balances

**Reports & Analytics:**

- Monthly/yearly spending summary
- Category-wise breakdown (food, transport, etc.)
- Group spending analysis
- Per-person spending in groups
- Export transactions (CSV, PDF)
- Spending trends over time
- Compare spending with friends

**Advanced Features:**

- Currency support (multiple currencies)
- Currency conversion for international groups
- Split by custom criteria:
  - By income ratio
  - By consumption (who ate/used more)
- Tax and tip calculation:
  - Add tax percentage to bill
  - Add tip and split it
- Expense approval workflow (for corporate/formal groups)
- Comments on expenses
- Receipt scanning and auto-amount detection (OCR)
- Offline mode (sync when online)

**Edge Cases to Handle:**

- Delete user with pending balances (transfer debts)
- Remove group member with debts (must settle first or transfer)
- Edit expense that's already partially settled
- Handle floating-point precision in money calculations
- Circular debts (A owes B, B owes C, C owes A)
- Concurrent expense additions by multiple users
- Split with unequal numbers of people
- Negative balances (overpayment/advance)

**Example Scenarios:**

_Scenario 1: Simple dinner split_

- 4 friends go to dinner, bill is $100
- Person A pays the full amount
- Split equally: Each owes A $25
- Result: B, C, D each owe A $25

_Scenario 2: Unequal split_

- Same dinner, but Person A ordered $40, others $20 each
- Person A pays full bill
- By item split: B, C, D each owe A $20

_Scenario 3: Trip with multiple expenses_

- 3 friends on trip
- Day 1: A pays $300 for hotel
- Day 2: B pays $150 for meals
- Day 3: C pays $90 for transport
- Without simplification:
  - B owes A $100, C owes A $100
  - A owes B $50, C owes B $50
  - A owes C $30, B owes C $30
- With simplification:
  - C owes A $40
  - B owes A $20

_Scenario 4: Partial payment_

- A owes B $100
- A pays B $60
- Remaining: A owes B $40

---

### 24. Online Shopping Cart

**Requirements:**

- Product catalog:
  - Product ID, name, description, price, images
  - Categories and subcategories
  - Stock availability
  - Product variants (size, color)
- Cart operations:
  - Add product (with quantity and variant)
  - Update quantity
  - Remove item
  - Clear cart
  - Save for later (wishlist)
- Cart rules:
  - Max quantity per product
  - Stock validation (ensure available)
  - Handle concurrent purchases (pessimistic locking)
- Pricing:
  - Subtotal calculation
  - Apply discounts/coupons
  - Calculate tax based on location
  - Shipping cost based on location and weight
  - Total amount
- Discount types:
  - Percentage off (20% off)
  - Fixed amount off ($10 off)
  - Buy X get Y free
  - Minimum purchase requirement
  - First-time buyer discount
  - Apply multiple discounts (with rules)
- Cart persistence:
  - Guest cart (session-based)
  - Logged-in user cart (database)
  - Merge carts on login
- Inventory management:
  - Reserve items during checkout
  - Release if checkout abandoned
  - Handle out-of-stock items
- Checkout flow:
  - Shipping address
  - Billing address
  - Payment method selection
  - Order review
  - Place order
- Recommendations:
  - Frequently bought together
  - Similar products
  - Complete the look
- Cart abandonment:
  - Save cart state
  - Email reminder
  - Special discount to recover
- Support guest checkout (no registration required)
- Handle different sellers (marketplace model)
- Shipping options:
  - Standard (5-7 days)
  - Express (2-3 days)
  - Overnight
- Gift options: gift wrap, gift message

---

## Problem Categories Summary

### Pattern Usage by Category:

**CRUD Apps:**

- Minimal patterns needed
- Focus: Entity modeling, relationships, state management

**Games:**

- Strategy Pattern (AI players, difficulty)
- State Pattern (game states)
- Command Pattern (move history)
- Observer Pattern (UI updates)

**Library Implementations:**

- Decorator Pattern (adding functionality)
- Factory Pattern (different implementations)
- Singleton Pattern (global access)
- Focus: Thread safety, performance, clean interfaces

**System Design Components:**

- Observer/Pub-Sub Pattern
- Factory + Strategy (worker types)
- Queue-based architectures
- Focus: Concurrency, scalability, failure handling

**Hierarchical Structures:**

- Composite Pattern (tree structures)
- Visitor Pattern (operations across hierarchy)
- Focus: Recursive operations, path resolution

**Workflow/State Machines:**

- State Pattern (state transitions)
- Chain of Responsibility (sequential processing)
- Template Method (common workflow)
- Focus: Complex state management, validation

---

## General Approach for OOD Interviews

1. **Clarify requirements first** - Don't jump to patterns
2. **Identify entities and relationships** - What are the main objects?
3. **Define key operations** - What can these objects do?
4. **Start simple** - Add patterns only when complexity justifies them
5. **Think about extensibility** - "What if we need to add X later?"
6. **Consider edge cases** - How to handle errors and invalid states?
7. **Discuss trade-offs** - Performance vs simplicity, flexibility vs complexity

### Common Pattern Combinations:

- Strategy + Factory
- Observer + Command
- Composite + Visitor
- State + Template Method

Remember: **Patterns emerge from requirements, not the other way around.**
