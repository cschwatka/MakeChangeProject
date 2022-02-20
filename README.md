### Make Change Project

#### Description
This is a program to calculate change for a purchase.

#### Lessons Learned
Floating point/binary math issues with decimals are the real deal. I originally tried to use separate methods for each bill/unit of money, but then I realized I would need to not only pass in to 2x variables but also return 2x variables (was originally planning to pass/return runningChange and unit counts in and out). Then I googled and saw I need an array to do that which I haven't learned yet. So, I just used a bunch of waterfalling if statements. I ran in to an issue on my 5 dollar bills being counted as 1 dollar bills. Ashley helped me spot that. Used ternaries to deal with singular/plural noun output.

#### Technologies Used
Java
