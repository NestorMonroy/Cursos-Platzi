import turtle
import random

window = turtle.Screen()
nestor = turtle.Turtle()
window.colormode(255)
nestor.speed(0)
nestor.width(2)
window.bgcolor(12,51,94)
nestor.pencolor(144,29,16)

def shape(angle, side, limit):
    reverseDirection = 200
    nestor.forward(side)

    if side % (reverseDirection*2) == 0:
        angle = angle + 2
        #print(side)
    elif side % reverseDirection == 0:
        angle = angle - 2
        #print(side)
    
    nestor.right(angle)
    side = side + 2
    if side < limit:
        shape(angle, side, limit)


angle = 119
side = 0
limit = 600
shape(angle, side, limit)

#tuple.done()

turtle.mainloop()


# colors = ['red', 'purple', 'blue', 'green', 'orange', 'yellow']

# t = turtle.Pen()
# t.speed(0)

# for x in range(360):
#     t.pencolor(colors[x%6])
#     t.width(x/100+2)
#     t.forward(x)
#     t.left(59)

# turtle.mainloop()

# nestor = turtle.Turtle()
# nestor.forward(50)
# nestor.left(90)
# nestor.forward(50)
# nestor.left(90)
# nestor.forward(50)
# nestor.left(90)
# nestor.forward(50)
# nestor.left(90)

# turtle.mainlopp()