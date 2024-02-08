<%@ include file="header.jsp"%>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <div class="card-body">
        <table class="table table-hover my-0" id="example3">
            <thead>
            <tr>
                <th>Name</th>
                <th class="d-none d-xl-table-cell">Start Date</th>
                <th class="d-none d-xl-table-cell">End Date</th>
                <th>Status</th>
                <th class="d-none d-md-table-cell">Assignee</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Project Apollo</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-success">Done</span></td>
                <td class="d-none d-md-table-cell">Vanessa Tucker</td>
            </tr>
            <tr>
                <td>Project Fireball</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-danger">Cancelled</span></td>
                <td class="d-none d-md-table-cell">William Harris</td>
            </tr>
            <tr>
                <td>Project Hades</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-success">Done</span></td>
                <td class="d-none d-md-table-cell">Sharon Lessman</td>
            </tr>
            <tr>
                <td>Project Nitro</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-warning">In progress</span></td>
                <td class="d-none d-md-table-cell">Vanessa Tucker</td>
            </tr>
            <tr>
                <td>Project Phoenix</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-success">Done</span></td>
                <td class="d-none d-md-table-cell">William Harris</td>
            </tr>
            <tr>
                <td>Project X</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-success">Done</span></td>
                <td class="d-none d-md-table-cell">Sharon Lessman</td>
            </tr>
            <tr>
                <td>Project Romeo</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-success">Done</span></td>
                <td class="d-none d-md-table-cell">Christina Mason</td>
            </tr>
            <tr>
                <td>Project Wombat</td>
                <td class="d-none d-xl-table-cell">01/01/2023</td>
                <td class="d-none d-xl-table-cell">31/06/2023</td>
                <td><span class="badge bg-warning">In progress</span></td>
                <td class="d-none d-md-table-cell">William Harris</td>
            </tr>
            </tbody>
        </table>
        </div>
    </div>
</div>
<script>
    $(document).ready( function () {
        $("#example3").DataTable({
            "oLanguage": {
                "sSearch": "Qidiruv:",
                "sInfo": "_TOTAL_ ta ma'lumotdan (_START_ dan _END_) tagachasi ko'rsatildi.",
                "sLengthMenu": "_MENU_ ta natijani ko'rsatish rejimi",
                "sZeroRecords": "Bunday ma'lumot topilmadi!",
                "sInfoFiltered": "_MAX_ ta ma'lumotdan saralandi.",
                "sInfoEmpty": "Bironta ham ma'lumot topilmadi! ",
                "sEmptyTable": "Jadvalda ma'lumotlar mavjud emas!",
                "oPaginate": {
                    "sPrevious": "Oldingi sahifa",
                    "sNext": "Keyingi sahifa"
                }
            }
        });
    } );
</script>
<%@ include file="footer.jsp"%>