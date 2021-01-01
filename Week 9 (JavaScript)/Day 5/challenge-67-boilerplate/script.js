function myFunction() {
  let repoName = document.getElementById("countQueryRepositoryInput").value;
  let countType = document.getElementById("countQueryIssueType").value;

  let array = document.getElementsByTagName("tr"); //array

  for (let i = 0; i < array.length; i++) {
    const element = array[i];
    let name = element.innerText.split("	")[0];
    let total = element.innerText.split("	")[1];
    let open = element.innerText.split("	")[2];
    let my_issues = element.innerText.split("	")[3];
    if (repoName == name) {
      if (countType == "total") {
        alert(`${repoName} - ${total}`);
      } else if (countType == "open") {
        alert(`${repoName} - ${open}`);
      } else if (countType == "my_issues") {
        alert(`${repoName} - ${my_issues}`);
      }
    }
  }
}

let array = document.getElementsByTagName("th");
for (let index = 4; index < array.length; index++) {
  const element = array[index];
  const x = document.getElementById("countQueryRepositoryInput");
  const option = document.createElement("option");
  option.text = element.innerHTML;
  x.appendChild(option);
  console.log(element);
}
for (let index = 1; index < 4; index++) {
  const element = array[index];
  const y = document.getElementById("countQueryIssueType");
  const option = document.createElement("option");
  option.text = element.innerHTML;
  y.appendChild(option);
}
