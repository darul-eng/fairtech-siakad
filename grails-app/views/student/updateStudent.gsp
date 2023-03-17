<g:render template="/template/header"/>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Student</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-user me-1"></i>
                Input Student
            </div>
            <div class="card-body">
                <g:form controller="student" action="storeStudent" method="PATCH">
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="id" id="id"  value="${student.id}">
                    </div>
                    <div class="form-group">
                        <label for="nim">NIM</label>
                        <div class='value ${hasErrors(bean:student,field:'nim','errors')}'>
                            <input type="text" class="form-control" id="nim" name="nim" placeholder="NIM" value="${fieldValue(bean:student,field:'nim')}"/>
                            <g:hasErrors bean="${student}" field="nim">
                                <small class="errors text-danger"><g:message error="${student.errors.getFieldError('nim')}" /></small>
                            </g:hasErrors>
                        </div>
%{--                        <input type="text" class="form-control" name="nim" id="nim" placeholder="nim" value="${student.nim}">--}%
                        %{--                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--}%
                    </div>
                    <div class="form-group">
                        <label for="name">Nama</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Nama" value="${student.name}">
                    </div>
                    <div class="form-group">
                        <label for="name">Jurusan</label>
                        <select class="form-control" id="major" name="major">
                            <option value="">Pilih Jurusan</option>
                            <g:each in="${majors}" var="major">
                                <option value="${major.id}" ${student.major.id == major.id ? 'selected' : ''}>${major.name}</option>
                            </g:each>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="year_of_entry">Angkatan</label>
                        <input type="text" class="form-control" name="year_of_entry" id="year_of_entry" placeholder="Angkatan" min="1900" max="2099" value="${student.yearOfEntry}">
                    </div>
                    <div class="form-group form-check">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </g:form>
            </div>
        </div>
    </div>
</main>
<g:render template="/template/footer"/>