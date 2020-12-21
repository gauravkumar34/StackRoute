## Problem Statement: Interface with default methods

**In an existing Blog publishing application, a new feature needs to be added to check for informal/offensive content in blogs before publishing.
 This can be achieved by adding a default method without impacting the current implementations.**
 
 This exercise has 2 classes
 
    1. Blog
        - This class has following fields
            - blogId: int
            - blogTitle: String
            - blogContent: String
            - blogAuthor: String
            
        - Define default constructor
        - Define parameterized constructor to initialize all the properties 
        - Define Getters and Setters for all the properties

    2. BlogAuthoringServiceImpl
        - This class implements the interface BlogAuthoringService. Following methods should be implemented in this class.
     
           - publishBlog(Blog blog) : String
           - processBlog(Blog blog) : String
           
 *Default method rejectBlogForInformalWords(Blog blog): boolean*
 
     - This method should be implemented in the interface BlogAuthoringService
     - This method to return true if blog content contains informal words like "chill", "dude", "crap", "crazy".
  
            
## Instructions
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Ensure your code compiles without any errors/warning/deprecations 
- Follow best practices while coding