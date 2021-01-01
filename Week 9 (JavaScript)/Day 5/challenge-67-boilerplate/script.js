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
