document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('search-form').addEventListener('submit', function(event) {
        event.preventDefault();

        const query = document.getElementById('search-query').value;
        const criteria = document.getElementById('search-criteria').value;

        fetch(`/search?${criteria}=${query}`)
            .then(response => response.json())
            .then(data => {
                const candidateList = document.getElementById('candidate-list');
                candidateList.innerHTML = '';

                data.forEach(candidate => {
                    const row = document.createElement('tr');

                    const nameCell = document.createElement('td');
                    nameCell.textContent = candidate.candidateName;
                    row.appendChild(nameCell);

                    const emailCell = document.createElement('td');
                    emailCell.textContent = candidate.candidateEmail;
                    row.appendChild(emailCell);

                    const phoneCell = document.createElement('td');
                    phoneCell.textContent = candidate.candidatePhone;
                    row.appendChild(phoneCell);

                    const positionCell = document.createElement('td');
                    positionCell.textContent = candidate.currentPosition;
                    row.appendChild(positionCell);

                    const ownerHRCell = document.createElement('td');
                    ownerHRCell.textContent = candidate.ownerHR;
                    row.appendChild(ownerHRCell);

                    const statusCell = document.createElement('td');
                    statusCell.textContent = candidate.status;
                    row.appendChild(statusCell);

                    const actionCell = document.createElement('td');
                    const actionButton1 = document.createElement('button');
                    actionButton1.textContent = 'View';
                    actionButton1.addEventListener('click', function() {
                        // Handle view action
                    });
                    const actionButton2 = document.createElement('button');
                    actionButton.textContent = 'Edit';
                    actionButton.addEventListener('click', function() {
                        // Handle view action
                    });
                    const actionButton3 = document.createElement('button');
                    actionButton.textContent = 'Delete';
                    actionButton.addEventListener('click', function() {
                        // Handle view action
                    });
                    actionCell.appendChild(actionButton1);
                    actionCell.appendChild(actionButton2);
                    actionCell.appendChild(actionButton3);
                    row.appendChild(actionCell);

                    candidateList.appendChild(row);
                });
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    });
});