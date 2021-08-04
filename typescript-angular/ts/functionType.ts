
type CallBackError = Error | null;
type CallBack = (error: CallBackError, response: Object) => void;
type SendRequest = (cb: CallBack) => void;


// el resultado es void porque no tiene return
const sendRequest: SendRequest = (cb: any): void => {
  if (cb) {
    cb(null, { message: "Todo salio OK." })
  }

}