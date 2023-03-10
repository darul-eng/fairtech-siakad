<g:render template="/template/header"/>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Tables</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item">
                <a href="${g.createLink(uri: '/dashboard')}">Dashboard</a></li>
            <li class="breadcrumb-item active">Kartu Hasil Studi</li>
        </ol>
        <g:if test="${flash.message}">
            <div class="alert alert-success text-center">${flash.message}</div>
        </g:if>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                List Students
            </div>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>No.</th>
                        <th>Matakuliah</th>
                        <th>Kode</th>
                        <th>SKS</th>
                        <th>Nilai Angka</th>
                        <th>Nilai Huruf</th>
                        <th>SKS X Nilai</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        totalSKS = 0
                        bobotNilai = 0
                    %>
                    <g:each in="${studyPlans}" var="krs" status="i">
                        <tr>
                            <td>${i+1}</td>
                            <td>${krs.course.name}</td>
                            <td>${krs.course.code}</td>
                            <td>${krs.course.sks}</td>
                            <td>${krs.grade}</td>
                            <%
                                def grade = krs.grade
                                String nilaiHuruf = ""
                                if (grade >= 3.9 && grade <= 4){
                                    nilaiHuruf = "A"
                                }else if (grade >= 3.7 && grade < 3.9 ){
                                    nilaiHuruf = "A-"
                                }else if (grade >= 3.3 && grade < 3.7 ){
                                    nilaiHuruf = "B+"
                                }else if (grade >= 3.0 && grade < 3.3 ){
                                    nilaiHuruf = "B"
                                }else if (grade >= 2.7 && grade < 3.0 ){
                                    nilaiHuruf = "B-"
                                }else if (grade >= 2.3 && grade < 2.7 ){
                                    nilaiHuruf = "C+"
                                }else if (grade >= 2.0 && grade < 3.3 ){
                                    nilaiHuruf = "B+"
                                }else if (grade >= 1.7 && grade < 2.0 ){
                                    nilaiHuruf = "C-"
                                }else if (grade >= 0 && grade < 1.7 ){
                                    nilaiHuruf = "D"
                                }else if (grade == 0 ){
                                    nilaiHuruf = "E"
                                }else {
                                    nilaiHuruf = "Tidak valid"
                                }
                            %>
                            <td>${nilaiHuruf}</td>
                            <%
                                nilaiXSKS = (krs.course.sks * krs.grade).round(3)
                            %>
                            <td>${nilaiXSKS}</td>
                        </tr>
                        </tr>
                        <%
                            totalSKS += krs.course.sks
                            bobotNilai +=  (krs.course.sks * krs.grade).round(3)
                        %>
                    </g:each>
                    </tbody>
                </table>
%{--                <div class="overflow-auto">--}%
%{--                    <a class="font-weight-bolder text-decoration-none ml-2 d-inline-block">Total SKS: ${totalSKS} SKS</a>--}%
%{--                    <a href="${g.createLink(uri: '/add-course')}" class="btn btn-primary float-end">Cetak KHS</a>--}%
%{--                </div>--}%
                <div class="d-flex justify-content-between align-items-center ml-2">
                    <h6 class="font-weight-bold">Total SKS: ${totalSKS} SKS</h6>
                    <a href="${g.createLink(uri: '/add-course')}" class="btn btn-primary">Cetak KHS</a>
                </div>
                <%
                    ipk = 0
                    if (totalSKS > 0) {
                        ipk = bobotNilai / totalSKS
                    }else{
                        ipk = 0
                    }
                %>
                <div class="d-flex justify-content-between align-items-center ml-2" style="margin-top: -10px !important;">
                    <h6 class="font-weight-bold">IP Semester: ${ipk}</h6>
                </div>
%{--                <div class="overflow-auto">--}%
%{--                    <a class="font-weight-bolder text-decoration-none ml-2 d-inline-block">IP Semester: ${ipk}</a>--}%
%{--                </div>--}%
            </div>
        </div>
    </div>
</main>
<g:render template="/template/footer"/>

