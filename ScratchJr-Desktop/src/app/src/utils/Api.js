
let url = 'localhost:8080/tello/execute';

export default class Api {

  static requestFromServer (pos, whenDone) {
    console.log('requestFromServer', pos, url);
    var xmlrequest = new XMLHttpRequest();
    xmlrequest.addEventListener('error', transferFailed, false);
    xmlrequest.onreadystatechange = function () {
      if (xmlrequest.readyState == 4) {
        whenDone(pos, xmlrequest.responseText);
      }
    };
    xmlrequest.open('GET', url, true);
    xmlrequest.send(null);
    function transferFailed (e) {
        e.preventDefault();
        e.stopPropagation();
        // Failed loading
    }
  }
  static postRequest (pos, data, whenDone) {
    //var params = 'orem=ipsum&name=binny';
    console.log('requestFromServer', pos, url, data);
    var xmlrequest = new XMLHttpRequest();
    xmlrequest.addEventListener('error', transferFailed, false);
    xmlrequest.onreadystatechange = function () {
      if (xmlrequest.readyState == 4) {
        whenDone(pos, xmlrequest.responseText);
      }
    };
    xmlrequest.open('POST', url, true);
    xmlrequest.send(data);
    function transferFailed (e) {
        e.preventDefault();
        e.stopPropagation();
        // Failed loading
    }
  }
}