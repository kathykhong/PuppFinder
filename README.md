# My Personal Project

## PuppFinder

*Find your perfect beloved pup...*

In this term, I propose to design an application that will help prospective dog owners 
find their perfect pup or people who are just merely interested in dogs find more about 
dog breeds and their characteristics. Not all dog lovers are experts on dog breeds. 
Often, people describe the types of dogs they like with the dog's physical or 
behavioural characteristics such as size, fur coat, playfulness, and friendliness towards others. 

Here, the PuppFinder application will construct a set of questions that covers a wide variety of dog characteristics 
including the dog breed which will guide users to discovering their ideal pup. The application 
will provide the results of the questionnaire where users will be able to find more information
about the different dog breeds. Consequently, the user can narrow down their choices in a wish list.
Furthermore, the user will be able to rate the quality of service from the PuppFinder application.
-print out the final wish list where the user can review, and select the breed they wish to own

This project really interests me because I am a dog lover myself and wish to own a dog 
one day. Nonetheless, I do not know much about all the types of dogs besides popular
names such as a Poodle or a Chihuahua. There are just too many types and I often don't know where 
to start looking. Choosing a dog to take care of can be quite challenging for new dog owners.
Therefore, I hope that this application can help me and other people who are interested dogs but do not know a lot about dog breeds learn more about the different types based on the
preferred characteristics, and narrow down our options.  


<h3>User Stories</h3>

- As a user, I want to be able to answer questions that help me narrow down the dog breeds that exist to the ones that cater to my preferences
- As a user, I want to be able to view the results of the dog breeds that match my responses
- As a user, I want to be able to view an image of the selected dog breed in the results
- As a user, I want to be able to select a dog breed or multiple dog breeds in the resulting collection and add it to a WishList
- As a user, I want to be able to view my wish list and delete a selected dog if desired
- As a user, I want to be able to read more information about a selected dog breed in the wish list
- As a user, I want to be able to save the results of my wishList to file
- As a user, I want to be able to rate the quality of service in the PuppFinder application
- As a user, I want to be able to load the results of my wishList when the program starts

<br>
<br>

<h3> Instructions for Grader </h3>

In addition to adding the dog breeds in the results to a wish list using the "Add to Wish List" button:

- You can generate the first required event by selecting a dog breed in the *wish list* and clicking the "More Info" button.

- You can generate the second required event by selecting a dog breed in the *wish list* and clicking the "Delete" button.

- You can locate my visual component by selecting a dog breed and clicking the "View Image" button in the *dog breed results*.

- You can save the state of my application by clicking the "Save" button in the wish list. 

- The application automatically reloads, however, you can type "view" upon starting the application to see the previously saved 
wish list.

<br>
<br>

<h3> Phase 4: Task 2 </h3>

I have chosen the option to *include a type hierarchy in your code other than the one that uses the Saveable interface
introduced in Phase 2*. I noticed that the FileViewer, PhotoViewer, SavedWishList, WishListListener, and GuiStarter class 
have similar layout and formatting functionality but all display different content. Therefore, I created an abstract class, 
ContentFrame, that is extended by all five of these classes.

This ContentFrame abstract class contains the  setUpWindowSizeAndPlacement(int width, int height) and displayWindowOnTop() method 
implementations which is inherited and used by all 5 subclasses. In addition, I declared an abstract method setUpViewingContent() 
in the ContentFrame class. This method is overridden in all five subclasses and contains distinct functionality. In the GuiStarter
and WishListListener classes, this method works to setUp the list layout of dog breeds. In the PhotoViewer class, 
setUpViewingContent() is responsible for setting up the panel and displaying the images of the selected dog breed. 
Furthermore, the setUpViewingContent() method in the FileViewer class functions to layout the text area and present more information of the selected dog breed. In the SavedWishListViewer class, 
setUpViewingContent() is used to display the saved Wish List. 


<h3> Phase 4: Task 3 </h3>

I have attempted to increase cohesion in my application during phase 3 of this project. Initially, I ran into the issue
of having the PuppResultGUI class not only responsible for setting up the list display of the dog breeds as well as the 
button options (View Image, AddToWishList, WishList), but also responsible for all the responses upon clicking these buttons.
Similarly, the WishListGUI class also contained all the implementations for the responses to the Delete, MoreInfo, and 
Save button, in addition to the implementations relating to the Wish List display. 


To resolve the poor cohesion, I created 6 separate classes (AddToWishListListener, DeleteListener, MoreInfoListener, SaveListener,
ViewImageListener, and WishListListener) each of which implements ActionListener and functions to perform the 
appropriate responses upon the click of the corresponding button. 

While implementing the actionPerformed(Event e) method in the MoreInfoListener class, I also came to a problem where 
my for-loop was becoming too big because I was trying to layout the text area and load the text file while wrapping all the text neatly. 
I figured that this method was not only exceeding the line limit but the class is not following the Single Responsibility Principle. Hence, 
I created the class, FileViewer, that is solely responsible for setting up the text area, reading and formatting the text file for 
the selected dog breed. 

Other minor changes I did to improve my program include refactoring the filterSmall(), filterMedium(), filterLarge(), 
containsSmallOnly(), containsMediumOnly(), and containsLargeOnly(), into just two methods filterSize(String size) and 
containsSizeOnly(String size) in the DogBreed class. 

I also created an abstract class DogCollection that is extended by DogBreedSet and WishList. The DogBreedSet and WishList 
classes contain many of the same methods such as add(DogBreed db), and isEmpty(). Therefore, I moved all the overlapping
method implementations into the DogCollection class to reduce duplicate code. 


 




