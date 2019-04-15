# cs1302-ce30 Social Network Analytics

In this class exercise, students will explore the use of different sorting algorithms in the
context of various data analytics problems related to the MyFace social network.

## References and Prerequisites

* [CSCI 1302 Maven Repository](http://cobweb.cs.uga.edu/~mec/cs1302-mvn-repo/)
* [CSCI 1302 Maven Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/maven.md)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are
logged into the Nike server.

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full
command that you typed to make the related action happen. If context is necessary (e.g., the
command depends on your present working directory), then please note that context as well.

### Getting Started

1. **You need to be in a group with at least two people for this exercise.**
   We reccommend keeping the groups small. Some steps in this exercise need be
   done by each group member individually.

## Exercise Steps

1. Once each group member has completed the **Getting Started steps**,
   pick an ordering for the group members (e.g., Group Member 1, Group Member 2, etc.).
   If a step is being performed by one group member, then everyone is expected
   to watch, pay attention, and take notes.

1. **GROUP MEMBER 1:** Create a [new, private repository](https://github.com/new) on GitHub with
   the following information:

   | **Field**            | **Value**                                                        |
   |----------------------|------------------------------------------------------------------|
   | **Owner**            | _your account_                                                   |
   | **Repository Name**  | `cs1302-ce30-ce31`                                               |
   | **Description**      | `Repository for Class Exercise 30 and 31`                        |
   | **Public / Private** | Private -- You choose who can see and commit to this repository. |

   Do **NOT** "Initialize this repository with a README".
   Also, do **NOT** click on the dropdowns for a `.gitignore` or license file.

   Once complete, you should have a GitHub-hosted private Git repository at the following
   website URL: `https://github.com/your_username/cs1302-ce30-ce31` where `your_username` is
   your GitHub account username.

   Do **NOT** follow any of the setup instructions at this time.

1. **GROUP MEMBER 1:** On the repository's website, add your group members as collaborators
   by going to "Settings" → "Collaborators". This will send them an invite that they can
   accept either via email or by visiting the repository's website on GitHub.

1. **OTHER GROUP MEMBERS:** Go to the repository website on GitHub and accept the invition
   from Group Member 1. If you see a 404 error instead of an invitation, then double check
   the following:

   * Repository Website URL

   * Username that Group Member 1 used when they added you

   Before continuing, make sure each group member has access to the repository website.

1. **NEXT GROUP MEMBER:** On Nike, use Maven to create a project directory for this exercise
   called `cs1302-ce30-ce31` with a primary package called `cs1302.analytics`, then change
   into that directory and do the following:

   1. Delete the Maven-generated driver and the unit test files:

      ```
      $ rm -f src/main/java/cs1302/analytics/App.java
      $ rm -rf src/test
      ```

   1. Initialize a new local Git repository:

      ```
      $ git init
      ```

   1. Create a [`.gitignore`](https://git-scm.com/docs/gitignore) (hidden file) with the following contents:

      ```
      bin/
      doc/
      target/
      *.class
      hs_err_pid*
      *~
      \#*\#
      core.*
      ```

      Add and commit the `.gitignore` file to the local repository.

   1. Update the POM so that the project works with Java 8. After that, add and commit the `pom.xml` file to
      the local repository.

   1. Create blank source code files for the remaining checkpoints:

      ```
      $ touch src/main/java/cs1302/analytics/MyFaceDriver.java
      ```

      Add and commit `src` to the local repository.

   1. Before proceeding, ensure that all tracked files are committed.

   1. Visit the repository website on GitHub and copy the "SSH" URL (i.e., the `git@github...` URL)
      under "Quick setup", then follow these instructions on Nike to link your local repository
      to the one on GitHub:

      ```
      $ git remote add origin git@github.com:group_member_one/cs1302-ce30-ce31.git
      $ git push -u origin master
      ```

      If successful, everyone should now be able to see the exercise files on the
      repository website on GitHub!

1. **ALL GROUP MEMBERS:** If you are not the group member who just pushed, then visit the
   repository website on GitHub and copy the "SSH" URL from the green "Clone or download"
   button. Then, follow these instructions on Nike to clone the GitHub-hosted Git repostory
   onto your Nike account:

   ```
   $ git clone git@github.com:group_member_one/cs1302-ce30-ce31.git
   ```

   Change into the directory and confirm that everything is there! You can verify that
   the origin of the `clone` operation is the repository instance on GitHub by
   using the following command:

   ```
   $ git remote -v
   ```

1. **NEXT GROUP MEMBER:** On Nike, do the following:

   1. Add the add the [CSCI 1302 Maven Repository](http://cobweb.cs.uga.edu/~mec/cs1302-mvn-repo/)
      to the `<repositories>` section of your POM.

   1. Next, add the dependency info for the
      [`cs1302-sorting`](http://cobweb.cs.uga.edu/~mec/cs1302-mvn-site/cs1302-sorting/project-info.html) and
      [`cs1302-myface`](http://cobweb.cs.uga.edu/~mec/cs1302-mvn-site/cs1302-myface/project-info.html)
      projects to the `<dependencies>` section of your POM.

   1. Finally, create the basic skeleton code for a driver class in `MyFaceDriver.java` with the following
      code snippet in the `main` method (**add import statements as needed**):

      ```java
      // generate myface users
      MyFace socialNetwork = new MyFace(1000);
      MyFaceUser[] users = socialNetwork.getUsers().stream().toArray(MyFaceUser[]::new);
      System.out.printf("MyFace user count: %d\n", users.length);

      // setup sorting algorithm
      Comparator<Integer> c = Integer::compareTo;
      Swapper<Integer> s = Swapper.getStandardSwapper();
      Integer[] a = new Integer[] { 3, 6, 1, 32, 9, 2 };
      Sort<Integer> sort = new BubbleSort<>(a, 0, a.length - 1, c, s);
      sort.printStats();
      sort.printSorted();
      ```

   Make sure that everything compiles and runs with Maven, then add and commit
   both `pom.xml` and `MyFaceDriver.java`.

**CHECKPOINT**

<hr/>

Now it's time for some data analytics! Your employer has tasked you with marketing
your company's new product to a cross-section of users of the MyFace social network.
The data analytics approach that you take needs to be fast so that it impresses your
boss. Luckily, you have a
[MyFace API](http://cobweb.cs.uga.edu/~mec/cs1302-mvn-site/cs1302-myface/apidocs/index.html)
and a collection of
[sorting algorithm implementations](http://cobweb.cs.uga.edu/~mec/cs1302-mvn-site/cs1302-sorting/apidocs/index.html)
that support performance metrics for comparisons and swaps. You may want to refer to the table below to help make
your decision.


   | **Algorithm**      | **Average-Case Comparisons** | **Worst-Case Comparisons** | **Swaps** | **Stable** |
   |--------------------|------------------------------|----------------------------|-----------|------------|
   | **Selection Sort** | `O(n^2)`                     | `O(n^2)`                   | `O(n)`    | No         |
   | **Bubble Sort**    | `O(n^2)`                     | `O(n^2)`                   | `O(n^2)`  | Yes        |
   | **Insertion Sort** | `O(n^2)`                     | `O(n^2)`                   | `O(n^2)`  | Yes        |
   | **QuickSort**      | `O(n*log(n))`                | `O(n^2)`                   | `O(n^2)`  | No         |


1. **EVERYONE:** Consider a scenario where you need to sort the `users` array by user age using
   each of the four algorithms available in the `cs1302.sorting` package. In your notes,
   write down which algorithm you think will be able to sort it the fastest according to:
   i) comparisons; and ii) swaps.

1. **NEXT GROUP MEMBER:** Now, write the code in `main` to sort the `users` array by user age
   using each of the four algorithms available in the `cs1302.sorting` package. For this problem,
   you will need to supply a custom `Comparator<MyFaceUser>` implementation (probably using a
   lambda expression). You may use the standard swapper. You can omit the call to `printSorted`
   (too many users), however, you will probably want to include a call to `printStats`.

   1. Once your code code compiles and runs, **run it a couple times**. Each time, does your
      choice of algorithm win or lose? Write it in your notes!

   1. Stage, commit, and push all changes.

1. **EVERYONE:** Pull your changes from the group repository.

**CHECKPOINT**

<hr/>

Now for some better analytics! It turns out that hip young people like our product for some reason.
Your boss wants to cash in on that opportunity by having you find users with a maximal social score
based on a formula provided by the company's data scientists. Let's do this!

1. **EVERYONE:** Consider a scenario where you need to sort the `users` array by user
   *social score* from *high to low* using each of the four algorithms available in the `cs1302.sorting` package.
   A user's social score is defined as their friends count times the number of characters
   in their name (including spaces) divided by their age. Here is some pseudocode:

   ```
   score(user) = count(user.friends) * lenth(user.name) / user.age
   ```

   In your notes, write down which algorithm you think will be able to sort it the
   fastest according to: i) comparisons; and ii) swaps.

1. **NEXT GROUP MEMBER:** Now, write the code in `main` to sort the `users` array by user
   social score **from high to low** using each of the four algorithms available in the `cs1302.sorting` package.
   For this problem, you will need to supply a custom `Comparator<MyFaceUser>` implementation
   (probably using a lambda expression). You may use the standard swapper.

   1. Once your code code compiles and runs, **run it a couple times**. Each time, does your
      choice of algorithm win or lose? Write it in your notes!

   1. Stage, commit, and push all changes.

1. **EVERYONE:** Pull your changes from the group repository.

**CHECKPOINT**

<hr/>

Now for some heavy-duty analytics!

1. **EVERYONE:** It turns out that your company stores the elements of the `users` array on
   multiple servers on a network. This makes swapping elements in the array costly as network
   lag is involved. Consider a scenario where you need to sort the `users` array by user
   *social score* (as in the previous checkpoint) using each of the four algorithms available
   in the `cs1302.sorting` package.

   In your notes, write down which algorithm you think will be able to sort it the
   fastest according to: i) comparisons; and ii) swaps.

1. **NEXT GROUP MEMBER:** Now, write the code in `main` to sort the `users` array by user
   social score using each of the four algorithms available in the `cs1302.sorting` package.
   For this problem, you will need to supply a custom `Comparator<MyFaceUser>` implementation
   (probably using a lambda expression). You may use the `Swapper<MyFaceUser>` returned by
   `Swapper.getNetworkSwapper(100)` to simulate random network lag with a maximum delay of
   `100` milliseconds.

   1. Once your code code compiles and runs, **run it a couple times**. Each time, does your
      choice of algorithm win or lose? Write it in your notes!

   1. Stage, commit, and push all changes.

1. **EVERYONE:** Pull your changes from the group repository.

**CHECKPOINT**

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
