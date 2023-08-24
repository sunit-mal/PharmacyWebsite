// For cbn
document.getElementById('cbn').addEventListener('change', function () {
  if (this.checked) {
    document.getElementById('cbnid').style.display = 'block';
    document.getElementById('CBEDdetails').style.display = 'none';
    document.getElementById('cbq').style.display = 'none';
    document.getElementById('process').style.display = 'none';
    document.getElementById('done').style.display = 'block';
  } else {
    document.getElementById('cbnid').style.display = 'none';
  }
});

// For CBED
document.getElementById('chechByDate').addEventListener('change', function () {
  if (this.checked) {
    document.getElementById('CBEDdetails').style.display = 'block';
    document.getElementById('cbnid').style.display = 'none';
    document.getElementById('cbq').style.display = 'none';
    document.getElementById('process').style.display = 'none';
    document.getElementById('done').style.display = 'block';
  } else {
    document.getElementById('CBEDdetails').style.display = 'none';
  }
});

// For cbq
document.getElementById('cbqcheck').addEventListener('change', function () {
  if (this.checked) {
    document.getElementById('cbq').style.display = 'block';
    document.getElementById('cbnid').style.display = 'none';
    document.getElementById('CBEDdetails').style.display = 'none';
    document.getElementById('process').style.display = 'block';
    document.getElementById('done').style.display = 'none';
  } else {
    document.getElementById('cbq').style.display = 'none';
    document.getElementById('process').style.display = 'none';
    document.getElementById('done').style.display = 'block';
  }
});
