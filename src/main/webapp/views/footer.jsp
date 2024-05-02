</div>
</main>

<footer class="footer">
    <div class="container-fluid">
        <div class="row text-muted">
            <div class="col-6 text-start">
                <p class="mb-0">
                    <a class="text-muted" href="" target="_blank"><strong>Market Program</strong></a>								&copy;
                </p>
            </div>
            <div class="col-6 text-end">
                <ul class="list-inline">
                    <li class="list-inline-item">
                        <a class="text-muted" href="" target="_blank">Support</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
</div>
</div>
<script>
    $(document).ready( function () {
        $(".dataTable").DataTable({
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
<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<script src="<%=request.getContextPath()%>/js/all.min.js"></script>
<script src="https://cdn.datatables.net/v/bs5/dt-1.13.8/datatables.min.js"></script>
</body>
</html>