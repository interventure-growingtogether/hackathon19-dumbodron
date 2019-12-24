import { ClientRequest } from 'electron-compile';
let url = 'localhost:8080/tello/execute';

export default class Api {
  static postFetchRequest(pos, data, whenDone) {
    const options = {
      method: 'POST',
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      }
    }
    fetch('http://localhost:8080/tello/execute', options)
      .then(res => res.json())
      .then(res => console.log(res));
  }
}
