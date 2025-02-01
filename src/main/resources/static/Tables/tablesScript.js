function showTableSelectionModal() {
    document.getElementById('tableSelectionModal').style.display = 'block';
  }

  function closeModal() {
    document.getElementById('tableSelectionModal').style.display = 'none';
  }

  function loadTableData() {
    const selectedTable = document.getElementById('tableList').value;
    // Add logic to fetch and display data from the selected table
    console.log('Selected table: ' + selectedTable);
  }