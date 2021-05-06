hrs = 0
minu = 0
sec = 0

while hrs < 24:
    while minu < 60:
        while sec < 60:
            print('{} : {} : {}'.format(hrs, minu, sec))
            sec +=1
        minu += 1
        sec = 0
    hrs +=1
    minu =0


# from datetime import datetime
# import time
# import sys

# now = datetime.now()
# hrs = now.hour
# minu = now.minute
# sec = now.second

# while hrs<24:
#     while minu < 60:
#         while sec < 60:
#             current = str(hrs).zfill(2) + " : " + str(minu).zfill(2) + " : " + str(sec).zfill(2) + "\r"
#             sys.stdout.write(current)
#             sec += 1
#             time.sleep(1)
#         minu += 1 
#         sec = 0
#     hrs += 1
#     minu = 0
            