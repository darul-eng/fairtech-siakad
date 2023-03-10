<g:render template="/template/header"/>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Tables</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item">
                <a href="${g.createLink(uri: '/dashboard')}">Dashboard</a></li>
            <li class="breadcrumb-item active">Kartu Rencana Studi</li>
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
                        <th>Semester</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${courses}" var="course" status="i">
                        <tr>
                            <td>${i+1}</td>
                            <td>${course.name}</td>
                            <td>${course.code}</td>
                            <td>${course.sks}</td>
                            <td>${course.semester}</td>
                            <td>
                                <g:form controller="studyPlan" action="saveCourse" method="POST">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" name="id" id="id"  value="${course.id}">
                                    </div>
                                    <button type="submit" class="badge badge-primary btn-outline-primary">tambah</button>
                                </g:form>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <a href="${g.createLink(uri: '/study-plan')}" class="btn btn-primary float-right" >Simpan KRS</a>
            </div>
        </div>
    </div>
</main>
<g:render template="/template/footer"/>

