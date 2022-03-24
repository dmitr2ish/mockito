# mockito
By YouTube video course https://www.youtube.com/playlist?list=PL6Zs6LgrJj3vy7yWpH9xb3Y0I_pAPrvCU

**Good Unit test**
- easy to write
- readable
- reliable
- fast
- isolated

**Test doubles**
- test doubles is a generic term of any case where you replace a production object for testing purpose
- sometimes it is not possible to until test a code because of the anavailability of external dependency
- if code under test is dependent on database operations, it is not possible to until test the code unless the database is available
- if code under test is dependent on external services, it is not possible to until test the code unless the network is available
- if code under test is sending an email, it is not good to send email every time tests are run
- e.g think of a <i>stunt double</i>  in movies which replaces actor whenever actor is not available or actor needs to perform dangerous actions etc.

**Types of _Test doubles_** (dmitr2ish/com/github/mockito/test_doubles)
- Dummy
- Fake 
- Stub
- Mock
- Spy

**Fake** (dmitr2ish/com/github/mockito/test_doubles/fake)
- Fake objects are usually light weight objects used only for testing. They have working implementations, but not as actual production object.
- Fake objects have functional implementation, but its in very basic form.
- For example, instead of actual production database we can use an(in-memory database, hashmaps or lists) int test
![image](https://user-images.githubusercontent.com/60426238/159841033-0c5a3cdd-5e95-49f2-ad5b-a2bb6e8103f6.png)

**Dummy** (dmitr2ish/com/github/mockito/test_doubles/dummy)
- It doesn't have any business logic
- it is an object that is used only for code to compile
- For example, an object passed as a parameter to a costructor. It is passed just to make code compile.

**Stub** (dmitr2ish/com/github/mockito/test_doubles/stub)
- Stub object provides predefined answers to method executions made during the test.
- The behavior is hardcoded programmatically for a particular test.
- Instead of calling external service, stub is called and it returns back an expected response.
![image](https://user-images.githubusercontent.com/60426238/159841712-cb12d35f-6c14-4d54-845a-2ec7777897d0.png)

**Spy** (dmitr2ish/com/github/mockito/test_doubles/spy)
- Spy objects are very similar to Stubs, but they record information about how they were executed.
- Its mostly used with stubbed external dependency + recording every iteraction with external dependency.
![image](https://user-images.githubusercontent.com/60426238/159845630-b3c080bb-a967-4257-ba31-0b392ffb810f.png)

**Mock** (dmitr2ish/com/github/mockito/test_doubles/mock)
- Its works very similar to Spy.
- Mock object records method calls on it, and verifies later that the recorded calls match.
- The assert and behavior verification is done at **mock object**.
![image](https://user-images.githubusercontent.com/60426238/159846046-b87b5929-9ad5-42f2-bb18-28655f6e4d29.png)

**Mocking**
- Mocking help us in testing functionality of class in isolation.
- It does not require database connection, communicating to external servers or going over network to test a functionality.
- Mock objects simulate ral service by taking in actual input and returning back excpeted output.
![image](https://user-images.githubusercontent.com/60426238/159846578-43c726af-a1b1-482f-b1f4-ed014699b906.png)

<i>**Mockito framework**
- Mockito is an open source testing framework for Java.
- The framework allows the creation of test doubles objects (mock objects) for unit tests. It uses Java Reflection in order to create mock objects.
- It is one of the top 10 Java libraries used by Java developers.

**Benefits of Mockito**
- It saves developers from writing test doubles or mock objects on their own.
- It has support for exception handling.
- It has support for stubbing methods. It help us in returning configured response.
- It can check order of method calls and number of times method being called.
- Annotations support.
  </i>
  
**Mock with Annotations**
  
  for **Junit5**
  - methods and class can be not public
  - @ExtendWith(MockitoExtension.class) - extension for mock's annotation use
  - @Mock - dependency of test class
  - @InjectMocks - here we point where we want to inject our mock's dependency

  for **Junit4**
  - methods and class **must** be public
  - In Junit4 we have three case of mock init:
    - via @RunWith(MockitoJUnitRunner.class)
    - via  MockitoAnnotations.initMocks(this)
    - via @Rule MockitoJUnit.rule();
  - link to the project with Junit4 (https://github.com/dmitr2ish/mockito-junit4)

**Stubbing**
- One of the primary benefit of Mockito is ability to return a provided response when a specific method is called on mocked dependency.
- The process of writing how a given mock method should behave is called stubbing.
- The feature is performed in two ways -
  - Using Mockito's static method _when()_ + _thenReturn()_. It states that _when_ any specific method is called on mock object, _then return_ preconficured value.
  - Using Mockito's static method _doReturn()_ + _when()_. It stated that _do return_ preconfigured value, _when_ specific method is called on mock object.

  *tips
  - mockito uses _equals()_ method while matching arguments during stubbing.
  - in case response is not stubbed for a method, default values are returned when called.
    - for primitives - 0;
    - for boolean - false;
    - for Objects and Arrays - null;
    - for Collection - empty collection.

