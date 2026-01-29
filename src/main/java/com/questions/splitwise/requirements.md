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
