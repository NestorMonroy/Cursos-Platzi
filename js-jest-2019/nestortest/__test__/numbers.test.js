import { numbers } from "../numbers";

/**
 * 
    .toBeGreaterThan()           MAYOR: >
    .toBeGreaterThanOrEqual()    MAYOR IGUAL: >=
    .toBeLessThan()              MENOR: <
    .toBeLessThanOrEqual()       MERNOR IGUAL: <=
    .toBeCloseTo()               VALORES FLOTANTES 
 */

describe("Comparación de números", () => {
  test("Mayor qué", () => {
    expect(numbers(2, 2)).toBeGreaterThan(3);
  });

  test("Mayor ó igual qué", () => {
    expect(numbers(2, 2)).toBeGreaterThanOrEqual(4);
  });

  test("Menor qué", () => {
    expect(numbers(2, 2)).toBeLessThan(5);
  });

  test("Menor ó igual qué", () => {
    expect(numbers(2, 2)).toBeLessThanOrEqual(4);
  });

  test("Igualdad en un valor flotante", () => {
    expect(numbers(0.2, 0.2)).toBeCloseTo(0.4);
  });

  test("Diferencia en un valor flotante", () => {
    expect(numbers(0.2, 0.2)).not.toBeCloseTo(0.5);
  });
});
