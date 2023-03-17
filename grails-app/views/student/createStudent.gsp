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
                        <g:form controller="student" action="saveStudent" method="POST">
                            <div class="form-group">
                                <label for="nim">NIM</label>
                                <div class='value ${hasErrors(bean:student,field:'nim','errors')}'>
                                    <input type="text" class="form-control" id="nim" name="nim" placeholder="NIM" value="${fieldValue(bean:student,field:'nim')}"/>
                                    <g:hasErrors bean="${student}" field="nim">
                                        <small class="errors text-danger"><g:message error="${student.errors.getFieldError('nim')}" /></small>
                                    </g:hasErrors>
                                </div>
%{--                                <input type="text" class="form-control" name="nim" id="nim" placeholder="nim">--}%
%{--                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--}%
                            </div>
                            <div class="form-group">
                                <label for="name">Nama</label>
                                <div class='value ${hasErrors(bean:student,field:'name','errors')}'>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Nama" value="${fieldValue(bean:student,field:'name')}"/>
                                    <g:hasErrors bean="${student}" field="name">
                                        <small class="errors text-danger"><g:message error="${student.errors.getFieldError('name')}" /></small>
                                    </g:hasErrors>
                                </div>
%{--                                <input type="text" class="form-control" name="name" id="name" placeholder="Nama">--}%
                            </div>
                            <label for="major">Jurusan</label>
                            <div class="form-group">
%{--                                <input type="text" class="form-control" name="major" id="major" placeholder="Jurusan">--}%
                                <select class="form-control" id="major" name="major">
                                <option value="">Pilih Jurusan</option>
                                <g:each in="${majors}" var="major">
                                    <option value="${major.id}">${major.name}</option>
                                </g:each>
                                </select>
                                <g:hasErrors bean="${student}" field="major">
                                    <small  class="errors text-danger"><g:message error="${student.errors.getFieldError('major')}" /></small>
                                </g:hasErrors>
                            </div>
                            <div class="form-group">
                                <label for="yearOfEntry">Angkatan</label>
                                <div class='value ${hasErrors(bean:student,field:'yearOfEntry','errors')}'>
                                    <input type="text" class="form-control" id="yearOfEntry" name="yearOfEntry" placeholder="Angkatan" value="${fieldValue(bean:student,field:'yearOfEntry')}"/>
                                    <g:hasErrors bean="${student}" field="yearOfEntry">
                                        <small class="errors text-danger"><g:message error="${student.errors.getFieldError('yearOfEntry')}" /></small>
                                    </g:hasErrors>
                                </div>
%{--                                <input type="number" class="form-control" name="year_of_entry" id="year_of_entry" placeholder="Angkatan" min="1900" max="2099">--}%
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <div class='value ${hasErrors(bean:student,field:'password','errors')}'>
                                    <input type="text" class="form-control" id="password" name="password" placeholder="Password" value="${fieldValue(bean:student,field:'password')}"/>
                                    <g:hasErrors bean="${student}" field="password">
                                        <small class="errors text-danger"><g:message error="${student.errors.getFieldError('password')}" /></small>
                                    </g:hasErrors>
                                </div>
%{--                                <input type="text" class="form-control" name="password" id="password" placeholder="Password" required>--}%
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

