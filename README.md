A simple calculator for band kids who don't want to find their own midsets :)   
(note: uses high school hashes)

Example:
Side to Side | Front to Back
----- | -----
Side 1: 1.0 steps inside 45 yd | 5.0 steps front of Back Hash
Side 1: 3.0 steps inside 45 yd | 8.0 steps behind Front Hash
Side 2: 2.0 steps outside 35 yd | 4.75 steps behind Front Hash
Side 2: 3.0 steps inside 40 yd | 4.0 steps behind Front Hash
Side 2: On 45 yd | 8.0 steps behind Front Hash

Input:
```S1 1 in 45, 5 front BH
S1 3 in 45, 8 front FH
S2 2 out 35, 4.75 back FH
S2 3 in 40, 4 back FH
S2 0 in 45, 8 back FH
done
```

Output:
```
Start:  S1 1 in 45           5 front BH
End:    S1 3 in 45           8 front FH
Midset: S1 2.0 in 45         7.5 back FH

Start:  S1 3 in 45           8 front FH
End:    S2 2 out 35          4.75 back FH
Midset: S2 2.5 out 45        1.625 front FH

Start:  S2 2 out 35          4.75 back FH
End:    S2 3 in 40           4 back FH
Midset: S2 3.5 out 40        4.375 back FH

Start:  S2 3 in 40           4 back FH
End:    S2 0 in 45           8 back FH
Midset: S2 2.5 out 45        6.0 back FH
```
You can try it at the following link: https://replit.com/@jRaffill/midset-calculator, although repl.it unfortunately doesn't always run very well. 

Open Source Dependencies:
---------
This uses TextIO for input (https://github.com/beryx/text-io), which is published under an Apache-2.0 license.
