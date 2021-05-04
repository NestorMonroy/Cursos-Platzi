import React from "react";
import { Link } from "gatsby";
import { Button, StyledCart } from "../styles/components";
import priceFormat from "../utils/priceFormat";
import { CartContext } from "../Context";

export default function CartComponent() {
  const { cart } = React.useContext(CartContext);
  const [total, setTotal] = React.useState(0);

  const getTotal = () => {
    setTotal(
      cart.reduce((acc, current) => acc + current.price * current.quantity, 0)
    );
  };

  React.useEffect(() => {
    getTotal();
  }, []);

  //console.log(cart)
  return (
    <StyledCart>
      <h2>Shop Cart</h2>
      <table>
        <tbody>
          <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
          </tr>
          {cart.map((swag) => (
            <tr key={swag.id}>
              <td>
                <img src={swag.metadata.img} alt={swag.name} /> {swag.name}
              </td>
              <td>USD: {priceFormat(swag.price)}</td>
              <td>{swag.quantity}</td>
              <td>{priceFormat(swag.quantity * swag.price)}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <nav>
        <div>
          <h3>Subtotal</h3>
          <small>USD {priceFormat(total)} </small>
        </div>
        <div>
          <Link to="/">
            <Button type="outline">Back</Button>
          </Link>
          <Button>Buy</Button>
        </div>
      </nav>
    </StyledCart>
  );
}
