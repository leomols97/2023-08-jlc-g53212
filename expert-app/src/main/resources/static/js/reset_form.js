document.addEventListener('DOMContentLoaded', function () {
    const resetButton = document.querySelector('.btn-reset');

    if (resetButton) {
        resetButton.addEventListener('click', function (event) {
            event.preventDefault();

            const form = document.querySelector('form');
            form.reset();

            const defaultOption = document.getElementById('defaultOption');
            if (defaultOption) {
                defaultOption.selected = true;
            }
        });
    }
});
