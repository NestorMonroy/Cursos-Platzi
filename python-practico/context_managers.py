"""
    Los context managers son objetos de Python que proveen información contextual adicional al bloque de código. 
    Existen dos formas de implementar un context manager: con una clase o con un generador. 
    https://book.pythontips.com/en/latest/context_managers.html
    
"""

class CustomOpen(object):

    def __init__(self, filename):
        self.file = open(filename)

    def __enter__(self):
        return self.file

    def __exit__(self, ctx_type, ctx_value, ctx_traceback):
        self.file.close()


with CustomOpen('file') as f:
    contents = f.read()



from contextlib import contextmanager

@contextmanager
def custom_open(filename):
    f = open(filename)
    try:
        yield f
    finally:
        f.close()

with custom_open('file') as f:
    contents = f.read()