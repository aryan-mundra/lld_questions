Perfect. You’re now focusing on the “Java implementation decisions during LLD” layer, which is where many candidates struggle.

Here are 50 more questions. Don’t answer immediately—think about each one as if you’re coding an LLD solution.

Yes. These are the exact implementation doubts that interviewers indirectly test during LLD.

What you’re missing is not design patterns or collections. You’re missing Java object modeling decisions.

Practice questions like these:

Object Creation

1

class Product {
    private String id;
    private String name;
}

From Main:

Product p = ?

Should you do:

new Product();

or

new Product("P1","Laptop");

Why?

⸻

2

Product p = new Product();
p.setId("P1");
p.setName("Laptop");

vs

Product p = new Product("P1","Laptop");

Which approach is better for mandatory fields?

⸻

Accessing Objects Across Classes

3

File:

Inventory.java

contains:

Map<String, Product> products;

How will you access it from:

VendingMachine.java

Options:

inventory.getProducts()

or

inventory.findProduct(id)

Which is cleaner?

⸻

4

class Product {
    private String name;
}

Can Main do:

product.name = "Laptop";

Why not?

⸻

5

If Main needs product name:

System.out.println(product.getName());

Why do we use getter instead of making variable public?

⸻

final Questions

6

private final String id;

Can you create:

setId()

?

⸻

7

private final List<Product> products;

Can you do:

products.add(...)

?

Can you do:

products = new ArrayList<>();

?

⸻

8

final Product product = new Product();

Can you do:

product.setName("ABC");

?

⸻

Static Questions

9

class Constants {
    public static final String SUCCESS = "SUCCESS";
}

How do you access from Main?

Need object or not?

⸻

10

Product.totalProducts

When should field be static?

⸻

Enum Questions

11

enum Status {
    PAID,
    FAILED
}

How will Main set status?

⸻

12

enum Coin {
    FIVE(5),
    TEN(10);
}

How do you get value?

⸻

13

User enters:

String input = "PAID";

Convert it to:

Status.PAID

How?

⸻

Collection Questions

14

Map<String, Product> products

Need getter?

Or create:

addProduct()
removeProduct()
getProduct()

Which is safer?

⸻

15

Suppose you return:

getProducts()

Can Main clear entire inventory?

inventory.getProducts().clear();

What problem does this create?

⸻

16

Need users in insertion order.

Choose:

ArrayList
LinkedList
HashSet
LinkedHashSet

⸻

Dependency Questions

17

class VendingMachine {
    Inventory inventory;
}

Should inventory be:

new Inventory();

inside constructor?

or

passed from Main?

⸻

18

Inventory inventory = new Inventory();
VendingMachine vm = new VendingMachine(inventory);

Why is this preferred in LLD?

⸻

Interface Questions

19

Payment payment = new UpiPayment();

Why not:

UpiPayment payment = new UpiPayment();

⸻

20

List<Product> products = new ArrayList<>();

Why not:

ArrayList<Product> products = new ArrayList<>();

⸻

Most Important LLD Coding Questions

Whenever you create a field, ask yourself:

1. Should it be private?
2. Should it be final?
3. Should it have a getter?
4. Should it have a setter?
5. Should it be initialized in constructor?
6. Should it be static?
7. Should it be enum instead of String?
8. Should I expose the collection directly?
9. Should I pass dependency through constructor?
10. Should I code to interface (List, Map) instead of implementation (ArrayList, HashMap)?

If you can answer these 10 questions confidently while implementing Parking Lot, Vending Machine, BookMyShow, and Splitwise, you’ll stop going blank during LLD interviews because these are the decisions interviewers expect you to make naturally.






Encapsulation

1

private String name;

Should there be:

getName()

only or both getter and setter?

⸻

2

private Date createdAt;

Should you expose the Date object directly in getter?

⸻

3

private List<Order> orders;

Should getter return:

orders

or

Collections.unmodifiableList(orders)

⸻

4

When is it okay to make a variable public?

⸻

5

Should entity classes contain business logic?

Example:

Order.placeOrder()

or should service handle it?

⸻

Constructor Decisions

6

User()

or

User(id,name,email)

Which fields belong in constructor?

⸻

7

If object creation requires 8 parameters, should you still use constructor?

⸻

8

When should Builder Pattern be preferred?

⸻

9

Can a constructor call another constructor?

⸻

10

Should validation happen inside constructor?

⸻

Static Questions

11

private static int count;

When should field be static?

⸻

12

Can static method access instance variable?

Why?

⸻

13

Can instance method access static variable?

⸻

14

Should utility classes have constructors?

⸻

15

How would you prevent creation of Utility class objects?

⸻

Collection Decisions

16

Need fast lookup by id.

Choose:

List
Map

⸻

17

Need duplicate values.

Choose:

Set
List

⸻

18

Need sorted order automatically.

Choose:

HashMap
TreeMap
LinkedHashMap

⸻

19

Need insertion order.

Choose:

HashSet
LinkedHashSet

⸻

20

Need highest priority item first.

Choose:

Queue
PriorityQueue

⸻

Object Reference Questions

21

User u1 = new User();
User u2 = u1;

How many objects?

⸻

22

u2.setName("Aryan");

Will u1 change?

⸻

23

How would you create a copy of object?

⸻

24

Shallow copy vs deep copy?

⸻

25

Why can exposing internal objects be dangerous?

⸻

Enum Decisions

26

Vehicle type:

String

or

enum

⸻

27

Can enum have constructor?

⸻

28

Can enum contain methods?

⸻

29

Can enum implement interface?

⸻

30

Can enum be extended?

⸻

Interface Decisions

31

Payment payment = new UpiPayment();

Why preferred?

⸻

32

Can interface contain default methods?

⸻

33

Can interface contain static methods?

⸻

34

When should class implement multiple interfaces?

⸻

35

Interface vs Abstract Class?

⸻

Dependency Injection

36

class Service {
    Repository repo = new Repository();
}

Good or bad?

⸻

37

Why pass dependency through constructor?

⸻

38

What happens if dependency changes tomorrow?

⸻

39

Should service create its own dependencies?

⸻

40

How does constructor injection improve testing?

⸻

HashMap Specific

41

Map<String,User> users

Need setter for entire map?

⸻

42

Should Main be allowed to replace map?

⸻

43

Better:

users.put(...)

from Main

or

userService.addUser(...)

?

⸻

44

Can HashMap have null key?

⸻

45

Can TreeMap have null key?

⸻

LLD Coding Decisions

46

In Parking Lot:

Should Spot store Vehicle?

or Vehicle store Spot?

or both?

⸻

47

In BookMyShow:

Should Seat know Show?

or Show know Seat?

or both?

⸻

48

In Vending Machine:

Should Inventory expose internal map?

⸻

49

In Splitwise:

Should Expense contain User objects?

or User IDs?

⸻

50

Suppose you create:

private final Map<String,Product> products;

Should you create:

setProducts()

?

Why or why not?

⸻

If you can comfortably answer these 50 questions, you’ll be stronger than most candidates in the implementation part of LLD. The next level after this is practicing questions like:

* “Design a Parking Lot and justify every collection choice.”
* “Design Splitwise and justify every constructor/getter/setter/final keyword.”
* “Design Vending Machine and explain every access modifier.”

That’s the level where interviewers usually start probing deeply.
