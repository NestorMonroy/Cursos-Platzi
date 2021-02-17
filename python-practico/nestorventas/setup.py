from setuptools import setup


setup(
    name='nv',
    version='0.1',
    py_modules=['nv'],
    install_requires=[
        'Click',
    ],
    entry_points='''
        [console_scripts]
        nv=nv:cli
    ''',
)


"""
    Se crea un entorno virtual 
    python3 -m venv venv
    source venv/bin/activate
    se instala
    pip3 install --editable .
    validar
    which nv

"""