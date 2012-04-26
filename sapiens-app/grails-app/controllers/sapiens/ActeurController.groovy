package sapiens

import org.springframework.dao.DataIntegrityViolationException

class ActeurController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [acteurInstanceList: Acteur.list(params), acteurInstanceTotal: Acteur.count()]
    }

    def create() {
        [acteurInstance: new Acteur(params)]
    }

    def save() {
        def acteurInstance = new Acteur(params)
        if (!acteurInstance.save(flush: true)) {
            render(view: "create", model: [acteurInstance: acteurInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'acteur.label', default: 'Acteur'), acteurInstance.id])
        redirect(action: "show", id: acteurInstance.id)
    }

    def show() {
        def acteurInstance = Acteur.get(params.id)
        if (!acteurInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'acteur.label', default: 'Acteur'), params.id])
            redirect(action: "list")
            return
        }

        [acteurInstance: acteurInstance]
    }

    def edit() {
        def acteurInstance = Acteur.get(params.id)
        if (!acteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acteur.label', default: 'Acteur'), params.id])
            redirect(action: "list")
            return
        }

        [acteurInstance: acteurInstance]
    }

    def update() {
        def acteurInstance = Acteur.get(params.id)
        if (!acteurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acteur.label', default: 'Acteur'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (acteurInstance.version > version) {
                acteurInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'acteur.label', default: 'Acteur')] as Object[],
                          "Another user has updated this Acteur while you were editing")
                render(view: "edit", model: [acteurInstance: acteurInstance])
                return
            }
        }

        acteurInstance.properties = params

        if (!acteurInstance.save(flush: true)) {
            render(view: "edit", model: [acteurInstance: acteurInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'acteur.label', default: 'Acteur'), acteurInstance.id])
        redirect(action: "show", id: acteurInstance.id)
    }

    def delete() {
        def acteurInstance = Acteur.get(params.id)
        if (!acteurInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'acteur.label', default: 'Acteur'), params.id])
            redirect(action: "list")
            return
        }

        try {
            acteurInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'acteur.label', default: 'Acteur'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'acteur.label', default: 'Acteur'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
