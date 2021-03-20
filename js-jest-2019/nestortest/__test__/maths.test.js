import { sumar, multiplicar, restar, dividir } from "../maths.js";

describe("Calculos matematicos", () => {
  test("Prueba de sumas", () => {
    expect(sumar(1, 1)).toBe(2);
  });
  test("Multiplicar ", () => {
    expect(multiplicar(2, 2)).toBe(4);
  });
  test("Restar ", () => {
    expect(restar(10, 1)).toBe(9);
  });
  test("Dividr ", () => {
    expect(dividir(10, 2)).toBe(5);
  });

  test("Dividr ", () => {
    expect(sumar(2, 2)).toBeLessThanOrEqual(4);
  });
  
});
