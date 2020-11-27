import turtle

def main():
    window = turtle.Screen()
    nes = turtle.Turtle()

    make_square(nes)

    turtle.mainloop()


def make_square(nes):
    length = int (input('Tamano del cuadrado: '))

    for i in range(4):
        make_line_and_turn(nes, length)


def make_line_and_turn(nes, length):
    nes.forward(length)
    nes.left(90)



if __name__ == "__main__":
    main()
