document.addEventListener("DOMContentLoaded", function () {
    // Variables for mode of printing and fields
    const modeOfPrintingField = document.getElementById("modeOfPrinting");
    const numberOfSheetsField = document.getElementById("numberOfSheets");
    const numberOfPagesField = document.getElementById("numberOfPages");
    const customerCountField = document.getElementById("customerCount");

    modeOfPrintingField.addEventListener('change', function () {
        const mode = this.value;
        updateFields(mode);

        });

    customerCountField.addEventListener('input', function () {
        const mode = modeOfPrintingField.value; // Get the selected mode
        updateFields(mode);
    })

//        // Make the fields readonly after selection
//        numberOfSheetsField.setAttribute('readonly', true);
//        numberOfPagesField.setAttribute('readonly', true);

       function updateFields(mode) {
           const customerCount = parseInt(customerCountField.value) || 0; // Get customer count (ensure it's a number)

           if (mode === 'Simplex') {
               // If Simplex, number of sheets and pages are equal to customer count
               numberOfSheetsField.value = customerCount;
               numberOfPagesField.value = customerCount;
           } else if (mode === 'Duplex') {
               // If Duplex, number of pages should be customer count * 2
               numberOfSheetsField.value = customerCount;
               numberOfPagesField.value = customerCount * 2;
           }
       }

//    // Prevent manual editing of number of sheets and pages
//    [numberOfSheetsField, numberOfPagesField].forEach((field) => {
//        field.addEventListener("focus", function () {
//            this.blur();
//        });
//    });

    // Restrict date fields to today's and yesterday's dates
    const dateFields = document.querySelectorAll('input[type="date"]');
    const today = new Date();
    const yesterday = new Date(today);
    yesterday.setDate(today.getDate() - 1);

    const formatDate = (date) => date.toISOString().split("T")[0];
    const todayString = formatDate(today);
    const yesterdayString = formatDate(yesterday);

    dateFields.forEach((dateField) => {
        dateField.setAttribute("min", yesterdayString);
        dateField.setAttribute("max", todayString);
    });

    // Dropdown field selector
    const fieldSelector = document.getElementById("fieldSelector");
    fieldSelector.addEventListener('change', function () {
        const selectedField = this.value;
        alert("You selected: " + selectedField);  // For now, just show an alert (you can customize this)

        // You can implement additional logic based on the selected dropdown value
        // For example, enabling or disabling certain fields, pre-filling values, etc.
    });

    // Form submission logic
    document.getElementById("misData").addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the default form submission

        if (sessionStorage.getItem("formSubmitted")) {
            alert("Form has already been submitted.");
            return;
        }

        const formData = new FormData(misData);
        const jsonObject = Object.fromEntries(formData.entries());

        fetch("/MisSave", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(jsonObject),
        })
        .then((response) => {
            if (response.redirected) {
                window.location.href = response.url;
            } else {
                return response.text();
            }
        })
        .then((data) => {
            console.log("Success:", data);

            sessionStorage.setItem("formSubmitted", "true");

            // Clear form fields
            Array.from(NewMisForm.elements).forEach((field) => {
                if (
                    ["text", "number", "date"].includes(field.type) ||
                    field.tagName === "SELECT"
                ) {
                    field.value = "";
                }
            });
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("An error occurred while submitting the form. Please try again.");
        });
    });
});
// Function to check the URL and show the form if 'showForm=true'
//    function checkURLAndToggleForm() {
//      const urlParams = new URLSearchParams(window.location.search);
//      const showForm = urlParams.get('showForm');
//
//      if (showForm === 'true') {
//        document.getElementById("misFormContainer").style.display = "block"; // Show the form
//      } else {
//        document.getElementById("misFormContainer").style.display = "none"; // Hide the form
//      }
//    }
//
//    // Call the function when the page loads
//    window.onload = checkURLAndToggleForm;
    function toggleForm(event) {
        // Prevent the default action (such as page redirection)
        event.preventDefault();

        const form = document.getElementById('misForm');
        // Toggle visibility of the MIS form
        form.style.display = (form.style.display === 'none' || form.style.display === '') ? 'block' : 'none';
    }
//// Toggle form visibility
//function toggleForm(event) {
//    event.preventDefault(); // Prevent the default action (such as page redirection)
//
//    const form = document.getElementById('misForm');
//    form.style.display = (form.style.display === 'none' || form.style.display === '') ? 'block' : 'none';
//}
