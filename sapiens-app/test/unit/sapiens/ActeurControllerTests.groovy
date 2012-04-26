package sapiens



import org.junit.*
import grails.test.mixin.*

@TestFor(ActeurController)
@Mock(Acteur)
class ActeurControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/acteur/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.acteurInstanceList.size() == 0
        assert model.acteurInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.acteurInstance != null
    }

    void testSave() {
        controller.save()

        assert model.acteurInstance != null
        assert view == '/acteur/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/acteur/show/1'
        assert controller.flash.message != null
        assert Acteur.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/acteur/list'


        populateValidParams(params)
        def acteur = new Acteur(params)

        assert acteur.save() != null

        params.id = acteur.id

        def model = controller.show()

        assert model.acteurInstance == acteur
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/acteur/list'


        populateValidParams(params)
        def acteur = new Acteur(params)

        assert acteur.save() != null

        params.id = acteur.id

        def model = controller.edit()

        assert model.acteurInstance == acteur
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/acteur/list'

        response.reset()


        populateValidParams(params)
        def acteur = new Acteur(params)

        assert acteur.save() != null

        // test invalid parameters in update
        params.id = acteur.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/acteur/edit"
        assert model.acteurInstance != null

        acteur.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/acteur/show/$acteur.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        acteur.clearErrors()

        populateValidParams(params)
        params.id = acteur.id
        params.version = -1
        controller.update()

        assert view == "/acteur/edit"
        assert model.acteurInstance != null
        assert model.acteurInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/acteur/list'

        response.reset()

        populateValidParams(params)
        def acteur = new Acteur(params)

        assert acteur.save() != null
        assert Acteur.count() == 1

        params.id = acteur.id

        controller.delete()

        assert Acteur.count() == 0
        assert Acteur.get(acteur.id) == null
        assert response.redirectedUrl == '/acteur/list'
    }
}
