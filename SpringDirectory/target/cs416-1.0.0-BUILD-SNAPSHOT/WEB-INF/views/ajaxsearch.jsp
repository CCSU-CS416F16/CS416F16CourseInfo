<html>
  <head>
    <TITLE>Search for students by AJAX</TITLE>
    <script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script type="text/javascript">
      function getMatchingStudents() {
        $.ajax({
          url: 'ajaxmatchingstudents',
          data: "passedName=" + document.getElementById('firstName').value,
          success: function (data) {
            $('#result').html(data);
          }
        });
      }
    </script>
  </head>
  <body>
    <div align="center">
      <h1>Student search</h1>
      Student's first name:<input type="text" id="firstName" size="50" onkeyup="getMatchingStudents();"/>
      <div id="result"></div>
      <a href="addstudent">Add a student</a><br/>
      <a href="classes">List classes</a>
    </div>



  </body>
</html>