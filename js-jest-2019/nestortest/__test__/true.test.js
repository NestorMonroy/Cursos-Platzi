import { isNull, isTrue, isFalse, isUndefined } from "../true.js";

/**
    .toBeNull()       DATOS NULL
    .toBeTruthy()     DATOS VERDADEROS
    .toBeFalsy()      DATOS FALSOS
    .toBeUndefined()  DATOS INDEFINIDOS
 */

describe("Probar resultados nulos", () => {
  test("Nulo", () => {
    expect(isNull()).toBeNull();
  });
});

describe("Probar resultados verdaderos", () => {
  test("Verdadero", () => {
    expect(isTrue()).toBeTruthy();
  });
});

describe("Probar resultados falsos", () => {
  test("Falso", () => {
    expect(isFalse()).toBeFalsy();
  });
});

describe("Probar resultados indefinidos", () => {
  test("Indefinido", () => {
    expect(isUndefined()).toBeUndefined();
  });
});
