package sapiens



import org.junit.*
import grails.test.mixin.*

@TestFor(SuiviCompetenceController)
@Mock(SuiviCompetence)
class SuiviCompetenceControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/suiviCompetence/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.suiviCompetenceInstanceList.size() == 0
        assert model.suiviCompetenceInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.suiviCompetenceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.suiviCompetenceInstance != null
        assert view == '/suiviCompetence/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/suiviCompetence/show/1'
        assert controller.flash.message != null
        assert SuiviCompetence.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/suiviCompetence/list'


        populateValidParams(params)
        def suiviCompetence = new SuiviCompetence(params)

        assert suiviCompetence.save() != null

        params.id = suiviCompetence.id

        def model = controller.show()

        assert model.suiviCompetenceInstance == suiviCompetence
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/suiviCompetence/list'


        populateValidParams(params)
        def suiviCompetence = new SuiviCompetence(params)

        assert suiviCompetence.save() != null

        params.id = suiviCompetence.id

        def model = controller.edit()

        assert model.suiviCompetenceInstance == suiviCompetence
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/suiviCompetence/list'

        response.reset()


        populateValidParams(params)
        def suiviCompetence = new SuiviCompetence(params)

        assert suiviCompetence.save() != null

        // test invalid parameters in update
        params.id = suiviCompetence.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/suiviCompetence/edit"
        assert model.suiviCompetenceInstance != null

        suiviCompetence.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/suiviCompetence/show/$suiviCompetence.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        suiviCompetence.clearErrors()

        populateValidParams(params)
        params.id = suiviCompetence.id
        params.version = -1
        controller.update()

        assert view == "/suiviCompetence/edit"
        assert model.suiviCompetenceInstance != null
        assert model.suiviCompetenceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/suiviCompetence/list'

        response.reset()

        populateValidParams(params)
        def suiviCompetence = new SuiviCompetence(params)

        assert suiviCompetence.save() != null
        assert SuiviCompetence.count() == 1

        params.id = suiviCompetence.id

        controller.delete()

        assert SuiviCompetence.count() == 0
        assert SuiviCompetence.get(suiviCompetence.id) == null
        assert response.redirectedUrl == '/suiviCompetence/list'
    }
}
