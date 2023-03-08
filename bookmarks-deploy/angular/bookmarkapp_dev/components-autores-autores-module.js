(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-autores-autores-module"],{

/***/ "./src/app/components/autores/autores-routing.module.ts":
/*!**************************************************************!*\
  !*** ./src/app/components/autores/autores-routing.module.ts ***!
  \**************************************************************/
/*! exports provided: AutoresRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AutoresRoutingModule", function() { return AutoresRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./detalle-autor/detalle-autor.component */ "./src/app/components/autores/detalle-autor/detalle-autor.component.ts");
/* harmony import */ var _lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./lista-autor/lista-autor.component */ "./src/app/components/autores/lista-autor/lista-autor.component.ts");






const routes = [{
        path: '', component: _lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_3__["ListaAutorComponent"]
    },
    {
        path: 'form', component: _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_2__["DetalleAutorComponent"]
    },
    {
        path: 'form/:id', component: _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_2__["DetalleAutorComponent"]
    }];
class AutoresRoutingModule {
}
AutoresRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: AutoresRoutingModule });
AutoresRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function AutoresRoutingModule_Factory(t) { return new (t || AutoresRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AutoresRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AutoresRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/components/autores/autores.module.ts":
/*!******************************************************!*\
  !*** ./src/app/components/autores/autores.module.ts ***!
  \******************************************************/
/*! exports provided: AutoresModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AutoresModule", function() { return AutoresModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./lista-autor/lista-autor.component */ "./src/app/components/autores/lista-autor/lista-autor.component.ts");
/* harmony import */ var _autores_routing_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./autores-routing.module */ "./src/app/components/autores/autores-routing.module.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var ag_grid_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ag-grid-angular */ "./node_modules/ag-grid-angular/__ivy_ngcc__/fesm2015/ag-grid-angular.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/__ivy_ngcc__/fesm2015/swimlane-ngx-datatable.js");
/* harmony import */ var ngx_mask__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ngx-mask */ "./node_modules/ngx-mask/__ivy_ngcc__/fesm2015/ngx-mask.js");
/* harmony import */ var _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./detalle-autor/detalle-autor.component */ "./src/app/components/autores/detalle-autor/detalle-autor.component.ts");












class AutoresModule {
}
AutoresModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: AutoresModule });
AutoresModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function AutoresModule_Factory(t) { return new (t || AutoresModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _autores_routing_module__WEBPACK_IMPORTED_MODULE_3__["AutoresRoutingModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
            ag_grid_angular__WEBPACK_IMPORTED_MODULE_6__["AgGridModule"],
            _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_7__["NgxDatatableModule"],
            ngx_mask__WEBPACK_IMPORTED_MODULE_8__["NgxMaskModule"].forChild()
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AutoresModule, { declarations: [_lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_2__["ListaAutorComponent"], _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_9__["DetalleAutorComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _autores_routing_module__WEBPACK_IMPORTED_MODULE_3__["AutoresRoutingModule"],
        _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
        ag_grid_angular__WEBPACK_IMPORTED_MODULE_6__["AgGridModule"],
        _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_7__["NgxDatatableModule"], ngx_mask__WEBPACK_IMPORTED_MODULE_8__["NgxMaskModule"]], exports: [_lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_2__["ListaAutorComponent"],
        _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_9__["DetalleAutorComponent"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AutoresModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_2__["ListaAutorComponent"], _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_9__["DetalleAutorComponent"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _autores_routing_module__WEBPACK_IMPORTED_MODULE_3__["AutoresRoutingModule"],
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
                    ag_grid_angular__WEBPACK_IMPORTED_MODULE_6__["AgGridModule"],
                    _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_7__["NgxDatatableModule"],
                    ngx_mask__WEBPACK_IMPORTED_MODULE_8__["NgxMaskModule"].forChild()
                ],
                exports: [
                    _lista_autor_lista_autor_component__WEBPACK_IMPORTED_MODULE_2__["ListaAutorComponent"],
                    _detalle_autor_detalle_autor_component__WEBPACK_IMPORTED_MODULE_9__["DetalleAutorComponent"]
                ]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/components/autores/detalle-autor/detalle-autor.component.ts":
/*!*****************************************************************************!*\
  !*** ./src/app/components/autores/detalle-autor/detalle-autor.component.ts ***!
  \*****************************************************************************/
/*! exports provided: DetalleAutorComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DetalleAutorComponent", function() { return DetalleAutorComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var src_app_models_autor_model__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/models/autor.model */ "./src/app/models/autor.model.ts");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var src_app_services_autor_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/services/autor.service */ "./src/app/services/autor.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");










function DetalleAutorComponent_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "AUTHOR.ADD_AUTHOR_TITLE"));
} }
function DetalleAutorComponent_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "AUTHOR.CONSULT_AUTHOR_TITLE"), " ");
} }
function DetalleAutorComponent_small_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "small", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.NAME_REQUIRED"));
} }
function DetalleAutorComponent_small_16_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "small", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.LAST_NAME_REQUIRED"));
} }
function DetalleAutorComponent_button_18_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "i", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r4.autorForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "SHARED.BUTTONS.SAVE"), " ");
} }
function DetalleAutorComponent_button_19_Template(rf, ctx) { if (rf & 1) {
    const _r7 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function DetalleAutorComponent_button_19_Template_button_click_0_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r7); const ctx_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r6.eliminarAutor(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "i", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 1, "SHARED.BUTTONS.DELETE"), " ");
} }
class DetalleAutorComponent {
    constructor(fb, activatedRoute, _autorService, router, _translateService) {
        this.fb = fb;
        this.activatedRoute = activatedRoute;
        this._autorService = _autorService;
        this.router = router;
        this._translateService = _translateService;
        this.autor = new src_app_models_autor_model__WEBPACK_IMPORTED_MODULE_2__["Autor"]();
        this.consulta = false;
    }
    get nombre() { return this.autorForm.get('nombre'); }
    get apellido() { return this.autorForm.get('apellido'); }
    ngOnInit() {
        this.activatedRoute.paramMap.subscribe(params => {
            let id = +params.get('id');
            if (id !== 0) {
                this.consulta = true;
                this._autorService.obtenerAutor(id).subscribe(autor => this.asignarValores(autor));
            }
        });
        this.initForm();
    }
    initForm() {
        this.autorForm = this.fb.group({
            nombre: [{ value: '', disabled: this.consulta }, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            apellido: [{ value: '', disabled: this.consulta }, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]
        });
    }
    asignarValores(autor) {
        this.autor = autor;
        this.autorForm.setValue({
            nombre: autor.nombre,
            apellido: autor.apellido
        });
    }
    guardarAutor() {
        if (this.autorForm.invalid) {
            return;
        }
        const { nombre, apellido } = this.autorForm.value;
        this.autor.nombre = nombre;
        this.autor.apellido = apellido;
        this._autorService.crearAutor(this.autor)
            .subscribe(autor => {
            sweetalert2__WEBPACK_IMPORTED_MODULE_3___default.a.fire(this._translateService.instant('DIALOG.AUTHOR_ADD'), `${this._translateService.instant('DIALOG.AUTHOR_ADD_TEXT')} ${autor.nombre} ${autor.apellido} ${this._translateService.instant('DIALOG.ADDED_SUCCESSFUL')}`, 'success');
            this.router.navigate(['/autores']);
        }, err => {
            sweetalert2__WEBPACK_IMPORTED_MODULE_3___default.a.fire({
                title: `${this._translateService.instant('DIALOG.ERROR_TITLE')}`,
                text: err.error.error,
                icon: 'error'
            });
        });
    }
    eliminarAutor() {
        sweetalert2__WEBPACK_IMPORTED_MODULE_3___default.a.fire({
            title: this._translateService.instant('DIALOG.DELETE_TITLE'),
            text: `${this._translateService.instant('DIALOG.AUTHOR_DELETE_ASK')} ${this.autor.nombre} ${this.autor.apellido}?`,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: this._translateService.instant('DIALOG.DELETE_YES'),
            cancelButtonText: this._translateService.instant('DIALOG.DELETE_NO'),
        }).then((result) => {
            if (result.isConfirmed) {
                this._autorService.borrarAutor(this.autor.id).subscribe(resp => {
                    sweetalert2__WEBPACK_IMPORTED_MODULE_3___default.a.fire(this._translateService.instant('DIALOG.AUTHOR_DELETED'), `${resp}`, 'success');
                    this.router.navigate(['autores']);
                }, err => {
                    sweetalert2__WEBPACK_IMPORTED_MODULE_3___default.a.fire({
                        title: `${this._translateService.instant('DIALOG.ERROR_TITLE')}`,
                        text: err.error.error,
                        icon: 'error'
                    });
                });
            }
        });
    }
}
DetalleAutorComponent.ɵfac = function DetalleAutorComponent_Factory(t) { return new (t || DetalleAutorComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](src_app_services_autor_service__WEBPACK_IMPORTED_MODULE_5__["AutorService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslateService"])); };
DetalleAutorComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: DetalleAutorComponent, selectors: [["app-detalle-autor"]], decls: 20, vars: 17, consts: [[1, "card", "mt-2"], ["class", "card-header text-center bg-card text-white", 4, "ngIf"], [1, "card-body", "txt-content"], [3, "formGroup", "ngSubmit"], [1, "form-group", "row"], [1, "col-form-label", "col-sm-2"], ["type", "text", "formControlName", "nombre", "required", "", 1, "form-control"], ["class", "text-danger ", 4, "ngIf"], ["type", "text", "formControlName", "apellido", "required", "", 1, "form-control"], [1, "form__content-submit"], ["type", "submit", "class", "form__submit", 3, "disabled", 4, "ngIf"], ["type", "button", "class", "form__submit", 3, "click", 4, "ngIf"], [1, "card-header", "text-center", "bg-card", "text-white"], [1, "text-danger"], ["type", "submit", 1, "form__submit", 3, "disabled"], [1, "bx", "bx-save", "icon-style"], ["type", "button", 1, "form__submit", 3, "click"], [1, "bx", "bx-trash", "icon-style"]], template: function DetalleAutorComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, DetalleAutorComponent_div_1_Template, 3, 3, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, DetalleAutorComponent_div_2_Template, 3, 3, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "form", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngSubmit", function DetalleAutorComponent_Template_form_ngSubmit_4_listener() { return ctx.guardarAutor(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "label", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](8, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "input", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, DetalleAutorComponent_small_10_Template, 3, 3, "small", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "label", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](14, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "input", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, DetalleAutorComponent_small_16_Template, 3, 3, "small", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](18, DetalleAutorComponent_button_18_Template, 4, 4, "button", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](19, DetalleAutorComponent_button_19_Template, 4, 3, "button", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", !ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.autorForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](8, 13, "AUTHOR.NAME"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-invalid", ctx.nombre.invalid && ctx.nombre.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.nombre.invalid && ctx.nombre.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](14, 15, "AUTHOR.LAST_NAME"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-invalid", ctx.apellido.invalid && ctx.apellido.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.apellido.invalid && ctx.apellido.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", !ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.consulta);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_7__["NgIf"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlName"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["RequiredValidator"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslatePipe"]], styles: ["[_ngcontent-%COMP%]:root {\r\n    --bg-color: #023877;\r\n    --hover-color-btn: #0074C7;\r\n    --disable-color-btn: #8ab4d1de;\r\n}\r\n\r\n.bg-card[_ngcontent-%COMP%] {\r\n    background: var(--bg-color);\r\n}\r\n\r\n.txt-content[_ngcontent-%COMP%] {\r\n    color: var(--bg-color);\r\n}\r\n\r\n.form__content-submit[_ngcontent-%COMP%] {\r\n    display: flex;\r\n    flex-direction: row;\r\n    justify-content: flex-start;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%] {\r\n    display: block;\r\n    width: 20%;\r\n    font-size: 18px;\r\n    background: var(--bg-color);\r\n    padding: 10px 20px;\r\n    border: none;\r\n    color: #fff;\r\n    font-weight: 700;\r\n    cursor: pointer;\r\n    margin-top: 15px;\r\n    border-radius: 10px;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%]:hover {\r\n    background: var(--hover-color-btn);\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%]:disabled {\r\n    background: var(--disable-color-btn);\r\n}\r\n\r\n.icon-style[_ngcontent-%COMP%] {\r\n    color: #fff;\r\n    display: inline-block;\r\n}\r\n\r\ntextarea[_ngcontent-%COMP%] {\r\n    height: 150px;\r\n    resize: none;\r\n}\r\n\r\n@media screen and (max-width:425px) {\r\n    label[_ngcontent-%COMP%] {\r\n        text-align: center;\r\n        font-size: 1rem;\r\n    }\r\n    small[_ngcontent-%COMP%] {\r\n        font-size: 0.8rem;\r\n        text-align: center;\r\n    }\r\n    .form__content-submit[_ngcontent-%COMP%] {\r\n        justify-content: center;\r\n    }\r\n    .form__submit[_ngcontent-%COMP%] {\r\n        width: 100%;\r\n        font-size: 1rem;\r\n    }\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9hdXRvcmVzL2RldGFsbGUtYXV0b3IvZGV0YWxsZS1hdXRvci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksbUJBQW1CO0lBQ25CLDBCQUEwQjtJQUMxQiw4QkFBOEI7QUFDbEM7O0FBRUE7SUFDSSwyQkFBMkI7QUFDL0I7O0FBRUE7SUFDSSxzQkFBc0I7QUFDMUI7O0FBRUE7SUFDSSxhQUFhO0lBQ2IsbUJBQW1CO0lBQ25CLDJCQUEyQjtBQUMvQjs7QUFFQTtJQUNJLGNBQWM7SUFDZCxVQUFVO0lBQ1YsZUFBZTtJQUNmLDJCQUEyQjtJQUMzQixrQkFBa0I7SUFDbEIsWUFBWTtJQUNaLFdBQVc7SUFDWCxnQkFBZ0I7SUFDaEIsZUFBZTtJQUNmLGdCQUFnQjtJQUNoQixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSxrQ0FBa0M7QUFDdEM7O0FBRUE7SUFDSSxvQ0FBb0M7QUFDeEM7O0FBRUE7SUFDSSxXQUFXO0lBQ1gscUJBQXFCO0FBQ3pCOztBQUVBO0lBQ0ksYUFBYTtJQUNiLFlBQVk7QUFDaEI7O0FBRUE7SUFDSTtRQUNJLGtCQUFrQjtRQUNsQixlQUFlO0lBQ25CO0lBQ0E7UUFDSSxpQkFBaUI7UUFDakIsa0JBQWtCO0lBQ3RCO0lBQ0E7UUFDSSx1QkFBdUI7SUFDM0I7SUFDQTtRQUNJLFdBQVc7UUFDWCxlQUFlO0lBQ25CO0FBQ0oiLCJmaWxlIjoic3JjL2FwcC9jb21wb25lbnRzL2F1dG9yZXMvZGV0YWxsZS1hdXRvci9kZXRhbGxlLWF1dG9yLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyI6cm9vdCB7XHJcbiAgICAtLWJnLWNvbG9yOiAjMDIzODc3O1xyXG4gICAgLS1ob3Zlci1jb2xvci1idG46ICMwMDc0Qzc7XHJcbiAgICAtLWRpc2FibGUtY29sb3ItYnRuOiAjOGFiNGQxZGU7XHJcbn1cclxuXHJcbi5iZy1jYXJkIHtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWJnLWNvbG9yKTtcclxufVxyXG5cclxuLnR4dC1jb250ZW50IHtcclxuICAgIGNvbG9yOiB2YXIoLS1iZy1jb2xvcik7XHJcbn1cclxuXHJcbi5mb3JtX19jb250ZW50LXN1Ym1pdCB7XHJcbiAgICBkaXNwbGF5OiBmbGV4O1xyXG4gICAgZmxleC1kaXJlY3Rpb246IHJvdztcclxuICAgIGp1c3RpZnktY29udGVudDogZmxleC1zdGFydDtcclxufVxyXG5cclxuLmZvcm1fX3N1Ym1pdCB7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIHdpZHRoOiAyMCU7XHJcbiAgICBmb250LXNpemU6IDE4cHg7XHJcbiAgICBiYWNrZ3JvdW5kOiB2YXIoLS1iZy1jb2xvcik7XHJcbiAgICBwYWRkaW5nOiAxMHB4IDIwcHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBjb2xvcjogI2ZmZjtcclxuICAgIGZvbnQtd2VpZ2h0OiA3MDA7XHJcbiAgICBjdXJzb3I6IHBvaW50ZXI7XHJcbiAgICBtYXJnaW4tdG9wOiAxNXB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogMTBweDtcclxufVxyXG5cclxuLmZvcm1fX3N1Ym1pdDpob3ZlciB7XHJcbiAgICBiYWNrZ3JvdW5kOiB2YXIoLS1ob3Zlci1jb2xvci1idG4pO1xyXG59XHJcblxyXG4uZm9ybV9fc3VibWl0OmRpc2FibGVkIHtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWRpc2FibGUtY29sb3ItYnRuKTtcclxufVxyXG5cclxuLmljb24tc3R5bGUge1xyXG4gICAgY29sb3I6ICNmZmY7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbn1cclxuXHJcbnRleHRhcmVhIHtcclxuICAgIGhlaWdodDogMTUwcHg7XHJcbiAgICByZXNpemU6IG5vbmU7XHJcbn1cclxuXHJcbkBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6NDI1cHgpIHtcclxuICAgIGxhYmVsIHtcclxuICAgICAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICAgICAgZm9udC1zaXplOiAxcmVtO1xyXG4gICAgfVxyXG4gICAgc21hbGwge1xyXG4gICAgICAgIGZvbnQtc2l6ZTogMC44cmVtO1xyXG4gICAgICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICAgIH1cclxuICAgIC5mb3JtX19jb250ZW50LXN1Ym1pdCB7XHJcbiAgICAgICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XHJcbiAgICB9XHJcbiAgICAuZm9ybV9fc3VibWl0IHtcclxuICAgICAgICB3aWR0aDogMTAwJTtcclxuICAgICAgICBmb250LXNpemU6IDFyZW07XHJcbiAgICB9XHJcbn1cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DetalleAutorComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-detalle-autor',
                templateUrl: './detalle-autor.component.html',
                styleUrls: ['./detalle-autor.component.css']
            }]
    }], function () { return [{ type: _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] }, { type: src_app_services_autor_service__WEBPACK_IMPORTED_MODULE_5__["AutorService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslateService"] }]; }, null); })();


/***/ }),

/***/ "./src/app/components/autores/lista-autor/lista-autor.component.ts":
/*!*************************************************************************!*\
  !*** ./src/app/components/autores/lista-autor/lista-autor.component.ts ***!
  \*************************************************************************/
/*! exports provided: ListaAutorComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListaAutorComponent", function() { return ListaAutorComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/__ivy_ngcc__/fesm2015/swimlane-ngx-datatable.js");
/* harmony import */ var _services_autor_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../services/autor.service */ "./src/app/services/autor.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");







const _c0 = ["editTmpl"];
const _c1 = ["hdrTpl"];
function ListaAutorComponent_ng_template_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0);
} if (rf & 2) {
    const column_r4 = ctx.column;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](column_r4.name);
} }
function ListaAutorComponent_ng_template_16_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
} if (rf & 2) {
    const value_r7 = ctx.value;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", value_r7, " ");
} }
class ListaAutorComponent {
    constructor(_autorService, _translateService, router) {
        this._autorService = _autorService;
        this._translateService = _translateService;
        this.router = router;
        this.data = [];
        this.cols = [];
        this.selected = [];
        this.SelectionType = _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__["SelectionType"];
        this.ColumnMode = _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__["ColumnMode"];
        this.autores = [];
    }
    ngOnInit() {
        this.initColumnsTable();
        this._autorService.getAutores().subscribe(resp => this.data = resp);
    }
    initColumnsTable() {
        this.cols = [
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: this._translateService.instant('AUTHOR.ID')
            },
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: this._translateService.instant('AUTHOR.NAME')
            },
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: this._translateService.instant('AUTHOR.LAST_NAME')
            }
        ];
    }
    onSelect({ selected }) {
        this.router.navigate(['/autores/form/', selected[0].id]);
    }
}
ListaAutorComponent.ɵfac = function ListaAutorComponent_Factory(t) { return new (t || ListaAutorComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_autor_service__WEBPACK_IMPORTED_MODULE_2__["AutorService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"])); };
ListaAutorComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ListaAutorComponent, selectors: [["app-lista-autor"]], viewQuery: function ListaAutorComponent_Query(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_c0, true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_c1, true);
    } if (rf & 2) {
        var _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.editTmpl = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.hdrTpl = _t.first);
    } }, decls: 18, vars: 17, consts: [[1, "card", "mb-3"], [1, "card-header", "text-center", "bg-card", "text-white"], [1, "card-body", "txt-content"], [1, "card-title"], [1, "mb-3", "form__content-submit"], ["type", "button", "routerLink", "/autores/form", 1, "form__submit"], [1, "bx", "bxs-folder-plus", "icon-style"], ["rowHeight", "auto", 1, "material", 3, "rows", "columns", "columnMode", "headerHeight", "footerHeight", "limit", "selected", "selectionType", "select"], ["hdrTpl", ""], ["editTmpl", ""]], template: function ListaAutorComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "h5", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "i", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](12, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "ngx-datatable", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("select", function ListaAutorComponent_Template_ngx_datatable_select_13_listener($event) { return ctx.onSelect($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, ListaAutorComponent_ng_template_14_Template, 1, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, ListaAutorComponent_ng_template_16_Template, 2, 1, "ng-template", null, 9, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 11, "BOOK.BOOK_TITLE"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 13, "AUTHOR.AUTHOR_LIST"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](12, 15, "SHARED.BUTTONS.ADD_AUTHOR"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("rows", ctx.data)("columns", ctx.cols)("columnMode", ctx.ColumnMode.force)("headerHeight", 50)("footerHeight", 50)("limit", 5)("selected", ctx.selected)("selectionType", ctx.SelectionType.single);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLink"], _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__["DatatableComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslatePipe"]], styles: ["[_ngcontent-%COMP%]:root {\r\n    --bg-color: #023877;\r\n    --hover-color-btn: #0074C7;\r\n    --disable-color-btn: #8ab4d1de;\r\n}\r\n\r\n.bg-card[_ngcontent-%COMP%] {\r\n    background: var(--bg-color);\r\n    font-size: 18px;\r\n}\r\n\r\n.form__content-submit[_ngcontent-%COMP%] {\r\n    display: flex;\r\n    flex-direction: row;\r\n    justify-content: flex-start;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%] {\r\n    display: block;\r\n    width: 20%;\r\n    font-size: 18px;\r\n    background: var(--bg-color);\r\n    padding: 10px 20px;\r\n    border: none;\r\n    color: #fff;\r\n    font-weight: 700;\r\n    cursor: pointer;\r\n    margin-top: 15px;\r\n    border-radius: 10px;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%]:hover {\r\n    background: var(--hover-color-btn);\r\n}\r\n\r\n@media screen and (max-width:425px) {\r\n    label[_ngcontent-%COMP%] {\r\n        text-align: center;\r\n        font-size: 1rem;\r\n    }\r\n    small[_ngcontent-%COMP%] {\r\n        font-size: 0.8rem;\r\n        text-align: center;\r\n    }\r\n    .form__content-submit[_ngcontent-%COMP%] {\r\n        justify-content: center;\r\n    }\r\n    .form__submit[_ngcontent-%COMP%] {\r\n        width: 100%;\r\n        font-size: 1rem;\r\n    }\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9hdXRvcmVzL2xpc3RhLWF1dG9yL2xpc3RhLWF1dG9yLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxtQkFBbUI7SUFDbkIsMEJBQTBCO0lBQzFCLDhCQUE4QjtBQUNsQzs7QUFFQTtJQUNJLDJCQUEyQjtJQUMzQixlQUFlO0FBQ25COztBQUVBO0lBQ0ksYUFBYTtJQUNiLG1CQUFtQjtJQUNuQiwyQkFBMkI7QUFDL0I7O0FBRUE7SUFDSSxjQUFjO0lBQ2QsVUFBVTtJQUNWLGVBQWU7SUFDZiwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLFlBQVk7SUFDWixXQUFXO0lBQ1gsZ0JBQWdCO0lBQ2hCLGVBQWU7SUFDZixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksa0NBQWtDO0FBQ3RDOztBQUVBO0lBQ0k7UUFDSSxrQkFBa0I7UUFDbEIsZUFBZTtJQUNuQjtJQUNBO1FBQ0ksaUJBQWlCO1FBQ2pCLGtCQUFrQjtJQUN0QjtJQUNBO1FBQ0ksdUJBQXVCO0lBQzNCO0lBQ0E7UUFDSSxXQUFXO1FBQ1gsZUFBZTtJQUNuQjtBQUNKIiwiZmlsZSI6InNyYy9hcHAvY29tcG9uZW50cy9hdXRvcmVzL2xpc3RhLWF1dG9yL2xpc3RhLWF1dG9yLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyI6cm9vdCB7XHJcbiAgICAtLWJnLWNvbG9yOiAjMDIzODc3O1xyXG4gICAgLS1ob3Zlci1jb2xvci1idG46ICMwMDc0Qzc7XHJcbiAgICAtLWRpc2FibGUtY29sb3ItYnRuOiAjOGFiNGQxZGU7XHJcbn1cclxuXHJcbi5iZy1jYXJkIHtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWJnLWNvbG9yKTtcclxuICAgIGZvbnQtc2l6ZTogMThweDtcclxufVxyXG5cclxuLmZvcm1fX2NvbnRlbnQtc3VibWl0IHtcclxuICAgIGRpc3BsYXk6IGZsZXg7XHJcbiAgICBmbGV4LWRpcmVjdGlvbjogcm93O1xyXG4gICAganVzdGlmeS1jb250ZW50OiBmbGV4LXN0YXJ0O1xyXG59XHJcblxyXG4uZm9ybV9fc3VibWl0IHtcclxuICAgIGRpc3BsYXk6IGJsb2NrO1xyXG4gICAgd2lkdGg6IDIwJTtcclxuICAgIGZvbnQtc2l6ZTogMThweDtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWJnLWNvbG9yKTtcclxuICAgIHBhZGRpbmc6IDEwcHggMjBweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGNvbG9yOiAjZmZmO1xyXG4gICAgZm9udC13ZWlnaHQ6IDcwMDtcclxuICAgIGN1cnNvcjogcG9pbnRlcjtcclxuICAgIG1hcmdpbi10b3A6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG59XHJcblxyXG4uZm9ybV9fc3VibWl0OmhvdmVyIHtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWhvdmVyLWNvbG9yLWJ0bik7XHJcbn1cclxuXHJcbkBtZWRpYSBzY3JlZW4gYW5kIChtYXgtd2lkdGg6NDI1cHgpIHtcclxuICAgIGxhYmVsIHtcclxuICAgICAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICAgICAgZm9udC1zaXplOiAxcmVtO1xyXG4gICAgfVxyXG4gICAgc21hbGwge1xyXG4gICAgICAgIGZvbnQtc2l6ZTogMC44cmVtO1xyXG4gICAgICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICAgIH1cclxuICAgIC5mb3JtX19jb250ZW50LXN1Ym1pdCB7XHJcbiAgICAgICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XHJcbiAgICB9XHJcbiAgICAuZm9ybV9fc3VibWl0IHtcclxuICAgICAgICB3aWR0aDogMTAwJTtcclxuICAgICAgICBmb250LXNpemU6IDFyZW07XHJcbiAgICB9XHJcbn0iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListaAutorComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-lista-autor',
                templateUrl: './lista-autor.component.html',
                styleUrls: ['./lista-autor.component.css']
            }]
    }], function () { return [{ type: _services_autor_service__WEBPACK_IMPORTED_MODULE_2__["AutorService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] }]; }, { editTmpl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['editTmpl', { static: true }]
        }], hdrTpl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['hdrTpl', { static: true }]
        }] }); })();


/***/ }),

/***/ "./src/app/models/autor.model.ts":
/*!***************************************!*\
  !*** ./src/app/models/autor.model.ts ***!
  \***************************************/
/*! exports provided: Autor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Autor", function() { return Autor; });
class Autor {
}


/***/ }),

/***/ "./src/app/services/autor.service.ts":
/*!*******************************************!*\
  !*** ./src/app/services/autor.service.ts ***!
  \*******************************************/
/*! exports provided: AutorService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AutorService", function() { return AutorService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");






class AutorService {
    constructor(http) {
        this.http = http;
        this.urlEndpoint = _environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].urlEndpoint;
        this.controller = 'autores';
    }
    getAutores() {
        return this.http.get(`${this.urlEndpoint}/${this.controller}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(err);
        }));
    }
    borrarAutor(id) {
        return this.http.delete(`${this.urlEndpoint}/${this.controller}/${id}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['message']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(err);
        }));
    }
    crearAutor(createAutor) {
        return this.http.post(`${this.urlEndpoint}/${this.controller}`, createAutor).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(err);
        }));
    }
    obtenerAutor(id) {
        return this.http.get(`${this.urlEndpoint}/${this.controller}/${id}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["throwError"])(err);
        }));
    }
}
AutorService.ɵfac = function AutorService_Factory(t) { return new (t || AutorService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"])); };
AutorService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: AutorService, factory: AutorService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AutorService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] }]; }, null); })();


/***/ })

}]);
//# sourceMappingURL=components-autores-autores-module.js.map