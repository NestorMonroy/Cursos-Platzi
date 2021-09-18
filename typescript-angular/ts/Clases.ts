class Transporte {
    private velocidad: number;
    private formaDeMovilidad: string;

    //Se utiliza cuando se inicializa la clase
    constructor(velocidad: number, formaDeMovilidad: string) {
        this.velocidad = velocidad;
        this.formaDeMovilidad = formaDeMovilidad;
    }

    //Indicar el encapzulamiento de nuestras propiedades
    getVelocidad() {
        return this.velocidad
    }

    setVelocidad(velocidad : number) {
        this.velocidad = this.velocidad
    }

    getFormaDeMovilidad() {
        return this.formaDeMovilidad
    }

    setFormaDeMovilidad(formaDeMovilidad: string) {
        this.formaDeMovilidad = this.formaDeMovilidad
    }

}

const transporte: Transporte = new Transporte(20, 'suelo');

//Herencia extenderla o redefinirlas
class Auto extends Transporte {
    private cantidadDePruertas: number;
    constructor(velocidad: number, formaDeMovilidad: string, cantidadDePuertas: number) {
        super(velocidad, formaDeMovilidad);
        this.cantidadDePruertas = cantidadDePuertas
    }

    getVelocidad() {
        return super.getVelocidad() + 10
        //return 'Mi velocidad es de un automovil y es de : ' + super.getVelocidad();
    }

    getcantidadDePruertas() {
        return this.cantidadDePruertas;
    }

    setcantidadDePruertas() {
        this.cantidadDePruertas = this.cantidadDePruertas;
    }

}


const auto:Auto = new Auto(20, 'suelo', 4);
