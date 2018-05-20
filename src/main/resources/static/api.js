
let reportedObject = {};

function showPosition(position) {
  let location = {};
  location.latitude = position.coords.latitude;
  location.longitude = position.coords.longitude;

  return location;
}

function getLocation() {
  if (navigator.geolocation) {
    return navigator.geolocation.getCurrentPosition(showPosition);
  }
  return null;
}

function sendReport(issueId) {
  let request = new XMLHttpRequest();

  request.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
    // TODO add thank you message
    console.log('thanks for reporting');
    }
  }

  // {
  //   "latitude" : "39.959946",
  //   "longitude" : "-83.00044439999999",
  //   "streetAddress" : "null",
  //   "issueId": "1",
  // }
  reportedObject.issueId = issueId;
  reportedObject.streetAddress = null;
  let location = getLocation();

  if(location) {
    reportedObject.latitude = location.latitude;
    reportedObject.longitude = location.longitude;
  } else {
    // Should not be hit
    reportedObject.latitude = null;
    reportedObject.longitude = null;
  }

  request.open("POST", '/api/report', true);
  request.setRequestHeader("Content-type", "application/json");
  request.setRequestHeader("Accept", "application/json");
  request.send(JSON.stringify(reportedObject));
}

function getIssueTypes(environment, category) {
  let request = new XMLHttpRequest();

  request.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      let response = JSON.parse(this.responseText);

      let categories = document.getElementById('categories');
      categories.style = "display: none";

      let typeOfIssues = document.getElementById('typeOfIssues');
      typeOfIssues.style = "display: block";

      response.forEach(item => {
        let child = document.createElement("button");
        child.addEventListener("click", function() {
          sendReport(item.id);
        });

        let list = document.createElement("li");
        list.innerHTML = item.typeOfIssue;

        // let img = document.createElement("img");
        // img.src= "../image/" + item.typeOfIssue.toLowerCase() + ".png";

        // child.appendChild(img);
        child.appendChild(list);

        typeOfIssues.appendChild(child);
      })
    }
  }

  request.open("GET", '/api/issues/'+environment.toLowerCase()+'/' + category.toLowerCase(), true);
  request.send();
}

function getCategories(environment) {
  let request = new XMLHttpRequest();

  request.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      let response = JSON.parse(this.responseText);

      let categories = document.getElementById('categories');
      categories.style = "display: block";

      let topLevel = document.getElementById('top-level');
      topLevel.style = "display: none";

      response.forEach(item => {
        let child = document.createElement("button");
        child.addEventListener("click", function() {
          getIssueTypes(environment, item);
        });

        let list = document.createElement("li");
        list.innerHTML = item;

        let img = document.createElement("img");
        img.src= "../image/" + item + ".png";

        child.appendChild(img);
        child.appendChild(list);

        categories.appendChild(child);
      })
    }
  }

  request.open("GET", '/api/issues/'+environment.toLowerCase()+'/categories', true);
  request.send();
}

function getEnvironments() {
  let request = new XMLHttpRequest();

  request.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      let response = JSON.parse(this.responseText);
      let element = document.getElementById('top-level');

      let title = document.createElement('p');
      title.innerText = 'Choose an environment';
      element.appendChild(title);

      let unordered = document.createElement('ul');

      response.forEach(item => {
        let child = document.createElement("button");
        child.addEventListener("click", function() {
          getCategories(item);
        });

        let list = document.createElement("li");
        list.innerHTML = item;

        let img = document.createElement("img");
        img.src= "../image/" + item + ".png";

        child.appendChild(img);
        child.appendChild(list);

        element.appendChild(child);
      })
    }
  }

  request.open("GET", '/api/issues/environments', true);
  request.send();
}
