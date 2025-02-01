  // Function to toggle the Add New MIS form
  function toggleForm(event) {
    event.preventDefault();
    const form = document.querySelector('.add-mis-form');
    form.style.display = (form.style.display === 'block') ? 'none' : 'block';
  }

  // Function to highlight the active menu item
  const menuLinks = document.querySelectorAll('.dashboard ul li a');
  menuLinks.forEach(link => {
    link.addEventListener('click', () => {
      menuLinks.forEach(link => link.classList.remove('active'));
      link.classList.add('active');
    });
  });

  // Toggle menu visibility (move sidebar inside/out)
  function toggleMenu() {
    const dashboard = document.querySelector('.dashboard');
    dashboard.classList.toggle('hidden');
  }