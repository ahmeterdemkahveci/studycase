1) Input series can be changed from data.txt where locates under src folder.
2) If you want to run with multiple input series, just add top and bottom then run the application.
    Example:
       9
       10 5 20 20 4 5 2 25 1
       10
       3 4 21 36 10 28 35 5 24 42
3) If your input series include different data types such as String ("a"), this value will be ignored.
4) If your input series include negative integer,it will also be ignored.
5) No memory restriction was considered during the development process of this case study. For example if your input has just one pair,time complexity will be O(n). On the other hand if you try to run multiple input, time complexity will be O(n^2).
