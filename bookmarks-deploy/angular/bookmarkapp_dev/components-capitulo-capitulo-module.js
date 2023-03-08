(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["components-capitulo-capitulo-module"],{

/***/ "./src/app/components/capitulo/capitulo-routing.module.ts":
/*!****************************************************************!*\
  !*** ./src/app/components/capitulo/capitulo-routing.module.ts ***!
  \****************************************************************/
/*! exports provided: CapituloRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CapituloRoutingModule", function() { return CapituloRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./detalle-capitulo/detalle-capitulo.component */ "./src/app/components/capitulo/detalle-capitulo/detalle-capitulo.component.ts");
/* harmony import */ var _lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./lista-capitulo/lista-capitulo.component */ "./src/app/components/capitulo/lista-capitulo/lista-capitulo.component.ts");






const routes = [
    {
        path: '', component: _lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__["ListaCapituloComponent"]
    },
    {
        path: 'page/:page', component: _lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__["ListaCapituloComponent"]
    },
    {
        path: 'form/libro/:libroId', component: _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_2__["DetalleCapituloComponent"]
    },
    {
        path: 'form/:id', component: _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_2__["DetalleCapituloComponent"]
    }
];
class CapituloRoutingModule {
}
CapituloRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: CapituloRoutingModule });
CapituloRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function CapituloRoutingModule_Factory(t) { return new (t || CapituloRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CapituloRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CapituloRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/components/capitulo/capitulo.module.ts":
/*!********************************************************!*\
  !*** ./src/app/components/capitulo/capitulo.module.ts ***!
  \********************************************************/
/*! exports provided: CapituloModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CapituloModule", function() { return CapituloModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _capitulo_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./capitulo-routing.module */ "./src/app/components/capitulo/capitulo-routing.module.ts");
/* harmony import */ var _lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./lista-capitulo/lista-capitulo.component */ "./src/app/components/capitulo/lista-capitulo/lista-capitulo.component.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./detalle-capitulo/detalle-capitulo.component */ "./src/app/components/capitulo/detalle-capitulo/detalle-capitulo.component.ts");
/* harmony import */ var ag_grid_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ag-grid-angular */ "./node_modules/ag-grid-angular/__ivy_ngcc__/fesm2015/ag-grid-angular.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/__ivy_ngcc__/fesm2015/swimlane-ngx-datatable.js");
/* harmony import */ var ngx_mask__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ngx-mask */ "./node_modules/ngx-mask/__ivy_ngcc__/fesm2015/ngx-mask.js");












class CapituloModule {
}
CapituloModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: CapituloModule });
CapituloModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function CapituloModule_Factory(t) { return new (t || CapituloModule)(); }, imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _capitulo_routing_module__WEBPACK_IMPORTED_MODULE_2__["CapituloRoutingModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
            ag_grid_angular__WEBPACK_IMPORTED_MODULE_7__["AgGridModule"],
            _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_8__["NgxDatatableModule"],
            ngx_mask__WEBPACK_IMPORTED_MODULE_9__["NgxMaskModule"].forChild()
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](CapituloModule, { declarations: [_lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__["ListaCapituloComponent"], _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_6__["DetalleCapituloComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _capitulo_routing_module__WEBPACK_IMPORTED_MODULE_2__["CapituloRoutingModule"],
        _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
        ag_grid_angular__WEBPACK_IMPORTED_MODULE_7__["AgGridModule"],
        _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_8__["NgxDatatableModule"], ngx_mask__WEBPACK_IMPORTED_MODULE_9__["NgxMaskModule"]], exports: [_lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__["ListaCapituloComponent"], _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_6__["DetalleCapituloComponent"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CapituloModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                declarations: [_lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__["ListaCapituloComponent"], _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_6__["DetalleCapituloComponent"]],
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _capitulo_routing_module__WEBPACK_IMPORTED_MODULE_2__["CapituloRoutingModule"],
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormsModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_5__["ReactiveFormsModule"],
                    ag_grid_angular__WEBPACK_IMPORTED_MODULE_7__["AgGridModule"],
                    _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_8__["NgxDatatableModule"],
                    ngx_mask__WEBPACK_IMPORTED_MODULE_9__["NgxMaskModule"].forChild()
                ],
                exports: [_lista_capitulo_lista_capitulo_component__WEBPACK_IMPORTED_MODULE_3__["ListaCapituloComponent"], _detalle_capitulo_detalle_capitulo_component__WEBPACK_IMPORTED_MODULE_6__["DetalleCapituloComponent"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "./src/app/components/capitulo/detalle-capitulo/detalle-capitulo.component.ts":
/*!************************************************************************************!*\
  !*** ./src/app/components/capitulo/detalle-capitulo/detalle-capitulo.component.ts ***!
  \************************************************************************************/
/*! exports provided: DetalleCapituloComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DetalleCapituloComponent", function() { return DetalleCapituloComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _models_capitulo_model__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../models/capitulo.model */ "./src/app/models/capitulo.model.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _models_create_capitulo_model__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../models/create.capitulo.model */ "./src/app/models/create.capitulo.model.ts");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! sweetalert2 */ "./node_modules/sweetalert2/dist/sweetalert2.all.js");
/* harmony import */ var sweetalert2__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(sweetalert2__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/__ivy_ngcc__/fesm2015/swimlane-ngx-datatable.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_capitulo_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/capitulo.service */ "./src/app/services/capitulo.service.ts");
/* harmony import */ var _services_marca_libro_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/marca-libro.service */ "./src/app/services/marca-libro.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");














const _c0 = ["editTmpl"];
const _c1 = ["hdrTpl"];
function DetalleCapituloComponent_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "CHAPTERS.ADD_CHAPTER_TITLE"));
} }
function DetalleCapituloComponent_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "CHAPTERS.CONSULT_CHAPTER_TITLE"), " ");
} }
function DetalleCapituloComponent_small_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "small", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.NUMBER_REQUIRED"));
} }
function DetalleCapituloComponent_small_16_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "small", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.NAME_REQUIRED"));
} }
function DetalleCapituloComponent_small_22_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "small", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.DESCRIPTION_REQUIRED"));
} }
function DetalleCapituloComponent_button_24_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "i", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r5.capituloForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "SHARED.BUTTONS.SAVE"), " ");
} }
function DetalleCapituloComponent_button_25_Template(rf, ctx) { if (rf & 1) {
    const _r9 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function DetalleCapituloComponent_button_25_Template_button_click_0_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r9); const ctx_r8 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r8.eliminarCapitulo(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "i", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 1, "SHARED.BUTTONS.DELETE"), " ");
} }
function DetalleCapituloComponent_div_26_div_4_Template(rf, ctx) { if (rf & 1) {
    const _r14 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "button", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function DetalleCapituloComponent_div_26_div_4_Template_button_click_1_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r14); const ctx_r13 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r13.crearMarcaLibro(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "i", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 1, "SHARED.BUTTONS.ADD_BOOK_MARK"), " ");
} }
function DetalleCapituloComponent_div_26_div_5_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.WARNING_LIST"), " ");
} }
function DetalleCapituloComponent_div_26_div_7_ng_template_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0);
} if (rf & 2) {
    const column_r19 = ctx.column;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](column_r19.name);
} }
function DetalleCapituloComponent_div_26_div_7_ng_template_4_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
} if (rf & 2) {
    const value_r22 = ctx.value;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", value_r22, " ");
} }
function DetalleCapituloComponent_div_26_div_7_Template(rf, ctx) { if (rf & 1) {
    const _r24 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "ngx-datatable", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("select", function DetalleCapituloComponent_div_26_div_7_Template_ngx_datatable_select_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r24); const ctx_r23 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r23.onSelect($event); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, DetalleCapituloComponent_div_26_div_7_ng_template_2_Template, 1, 1, "ng-template", null, 29, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, DetalleCapituloComponent_div_26_div_7_ng_template_4_Template, 2, 1, "ng-template", null, 30, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r12 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("rows", ctx_r12.marcasLibros)("columns", ctx_r12.cols)("columnMode", ctx_r12.ColumnMode.force)("headerHeight", 50)("footerHeight", 50)("limit", 10)("selected", ctx_r12.selected)("selectionType", ctx_r12.SelectionType.single);
} }
function DetalleCapituloComponent_div_26_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, DetalleCapituloComponent_div_26_div_4_Template, 5, 3, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, DetalleCapituloComponent_div_26_div_5_Template, 3, 3, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, DetalleCapituloComponent_div_26_div_7_Template, 6, 8, "div", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 4, "BOOK_MARKS.BOOK_MARK_TITLE"), " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r7.capituloId > 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx_r7.marcasLibros == null ? null : ctx_r7.marcasLibros.length) == 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r7.marcasLibros.length > 0);
} }
class DetalleCapituloComponent {
    constructor(activatedRoute, fb, router, _capituloService, _marcaLibroService, _translateService) {
        this.activatedRoute = activatedRoute;
        this.fb = fb;
        this.router = router;
        this._capituloService = _capituloService;
        this._marcaLibroService = _marcaLibroService;
        this._translateService = _translateService;
        this.consulta = false;
        this.capitulo = new _models_capitulo_model__WEBPACK_IMPORTED_MODULE_1__["Capitulo"]();
        this.createCapitulo = new _models_create_capitulo_model__WEBPACK_IMPORTED_MODULE_3__["CreateCapitulo"]();
        this.libroId = 0;
        this.marcasLibros = [];
        this.capituloId = 0;
        this.cols = [];
        this.selected = [];
        this.SelectionType = _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__["SelectionType"];
        this.ColumnMode = _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__["ColumnMode"];
    }
    get numero() { return this.capituloForm.get('numero'); }
    get nombre() { return this.capituloForm.get('nombre'); }
    get descripcion() { return this.capituloForm.get('descripcion'); }
    ngOnInit() {
        this.activatedRoute.paramMap.subscribe(params => {
            let libroId = +params.get('libroId');
            let id = +params.get('id');
            if (libroId !== 0 && id === 0) {
                this.consulta = false;
                this.libroId = libroId;
            }
            else if (libroId === 0 && id !== 0) {
                this.consulta = true;
                this._capituloService.obtenerCapitulo(id).subscribe(capitulo => this.asignarValores(capitulo));
                this.initColumnsTable();
                this._marcaLibroService.getMarcasLibrosByCapitulo(id).subscribe(marcas => {
                    this.marcasLibros = marcas;
                });
            }
        });
        this.initForm();
    }
    initForm() {
        this.capituloForm = this.fb.group({
            numero: [{ value: '', disabled: this.consulta }, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            nombre: [{ value: '', disabled: this.consulta }, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            descripcion: [{ value: '', disabled: this.consulta }, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required]
        });
    }
    guardarCapitulo() {
        if (this.capituloForm.invalid) {
            return;
        }
        const { numero, nombre, descripcion } = this.capituloForm.value;
        this.createCapitulo.numero = numero;
        this.createCapitulo.nombre = nombre;
        this.createCapitulo.descripcion = descripcion;
        this.createCapitulo.libroId = this.libroId;
        this._capituloService.crearCapitulo(this.createCapitulo)
            .subscribe(capitulo => {
            sweetalert2__WEBPACK_IMPORTED_MODULE_4___default.a.fire('Nuevo Capitulo', `El capitulo ${capitulo.nombre} ha sido creado con exito`, 'success');
            this.router.navigate(['/capitulos']);
        }, err => {
            sweetalert2__WEBPACK_IMPORTED_MODULE_4___default.a.fire({
                title: `Error ${err.error.status} !!!`,
                text: err.error.message,
                icon: 'error'
            });
        });
    }
    asignarValores(capitulo) {
        this.capituloForm.setValue({
            nombre: capitulo.nombre,
            descripcion: capitulo.descripcion,
            numero: capitulo.numero
        });
        this.capituloId = capitulo.id;
        this.capitulo = capitulo;
    }
    eliminarCapitulo() {
        sweetalert2__WEBPACK_IMPORTED_MODULE_4___default.a.fire({
            title: this._translateService.instant('DIALOG.DELETE_TITLE'),
            text: `${this._translateService.instant('DIALOG.CHAPTER_DELETE_ASK')} ${this.capitulo.nombre} ?`,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: this._translateService.instant('DIALOG.DELETE_YES'),
            cancelButtonText: this._translateService.instant('DIALOG.DELETE_NO'),
        }).then((result) => {
            if (result.isConfirmed) {
                this._capituloService.borrarCapitulo(this.capitulo.id).subscribe(resp => {
                    sweetalert2__WEBPACK_IMPORTED_MODULE_4___default.a.fire(this._translateService.instant('DIALOG.CHAPTER_DELETED'), `${resp}`, 'success');
                    this.router.navigate(['/capitulos']);
                }, err => {
                    sweetalert2__WEBPACK_IMPORTED_MODULE_4___default.a.fire({
                        title: `${this._translateService.instant('DIALOG.ERROR_TITLE')}`,
                        text: err.error.error,
                        icon: 'error'
                    });
                });
            }
        });
    }
    crearMarcaLibro() {
        this.router.navigate(['/libros/marcalibro/form/capitulo/', this.capituloId]);
    }
    initColumnsTable() {
        this.cols = [
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: this._translateService.instant('BOOK_MARKS.ID')
            },
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: 'Descripcion'
            }
        ];
    }
    onSelect({ selected }) {
        let idMarcaLibro = selected[0].id;
        let capituloId = selected[0].capitulo.id;
        this.router.navigate(['/libros/marcalibro/form/', capituloId, idMarcaLibro]);
    }
}
DetalleCapituloComponent.ɵfac = function DetalleCapituloComponent_Factory(t) { return new (t || DetalleCapituloComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_capitulo_service__WEBPACK_IMPORTED_MODULE_7__["CapituloService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_marca_libro_service__WEBPACK_IMPORTED_MODULE_8__["MarcaLibroService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslateService"])); };
DetalleCapituloComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: DetalleCapituloComponent, selectors: [["app-detalle-capitulo"]], viewQuery: function DetalleCapituloComponent_Query(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_c0, true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_c1, true);
    } if (rf & 2) {
        var _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.editTmpl = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.hdrTpl = _t.first);
    } }, decls: 27, vars: 24, consts: [[1, "card", "mt-2"], ["class", "card-header text-center bg-card text-white", 4, "ngIf"], [1, "card-body", "txt-content"], [3, "formGroup", "ngSubmit"], [1, "form-group", "row"], [1, "col-form-label", "col-sm-2"], ["type", "text", "formControlName", "numero", "required", "", 1, "form-control"], ["class", "text-danger ", 4, "ngIf"], ["type", "text", "formControlName", "nombre", "required", "", 1, "form-control"], ["formControlName", "descripcion", "required", "", 1, "form-control"], [1, "form__content-submit"], ["type", "submit", "class", "form__submit", 3, "disabled", 4, "ngIf"], ["type", "button", "class", "form__submit", 3, "click", 4, "ngIf"], ["class", "card mt-2", 4, "ngIf"], [1, "card-header", "text-center", "bg-card", "text-white"], [1, "text-danger"], ["type", "submit", 1, "form__submit", 3, "disabled"], [1, "bx", "bx-save", "icon-style"], ["type", "button", 1, "form__submit", 3, "click"], [1, "bx", "bx-trash", "icon-style"], ["class", "mb-2 form__content-submit", 4, "ngIf"], ["class", "alert-content alert alert-info", 4, "ngIf"], [1, "card-body", "text-primary"], [4, "ngIf"], [1, "mb-2", "form__content-submit"], ["type", "button", 1, "form__submit", "form__submit--detail", 3, "click"], [1, "bx", "bxs-folder-plus", "icon-style"], [1, "alert-content", "alert", "alert-info"], ["rowHeight", "auto", 1, "material", 3, "rows", "columns", "columnMode", "headerHeight", "footerHeight", "limit", "selected", "selectionType", "select"], ["hdrTpl", ""], ["editTmpl", ""]], template: function DetalleCapituloComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, DetalleCapituloComponent_div_1_Template, 3, 3, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, DetalleCapituloComponent_div_2_Template, 3, 3, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "form", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngSubmit", function DetalleCapituloComponent_Template_form_ngSubmit_4_listener() { return ctx.guardarCapitulo(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "label", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](8, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "input", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, DetalleCapituloComponent_small_10_Template, 3, 3, "small", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "label", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](14, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "input", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, DetalleCapituloComponent_small_16_Template, 3, 3, "small", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "label", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](20, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](21, "textarea", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](22, DetalleCapituloComponent_small_22_Template, 3, 3, "small", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](24, DetalleCapituloComponent_button_24_Template, 4, 4, "button", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](25, DetalleCapituloComponent_button_25_Template, 4, 3, "button", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](26, DetalleCapituloComponent_div_26_Template, 8, 6, "div", 13);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", !ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.capituloForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](8, 18, "CHAPTERS.NUMBER"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-invalid", ctx.numero.invalid && ctx.numero.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.numero.invalid && ctx.numero.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](14, 20, "CHAPTERS.NAME"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-invalid", ctx.nombre.invalid && ctx.nombre.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.nombre.invalid && ctx.nombre.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](20, 22, "CHAPTERS.DESCRIPTION"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-invalid", ctx.descripcion.invalid && ctx.descripcion.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.descripcion.invalid && ctx.descripcion.touched);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", !ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.consulta);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.consulta);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_10__["NgIf"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControlName"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["RequiredValidator"], _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_5__["DatatableComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslatePipe"]], styles: ["[_ngcontent-%COMP%]:root {\r\n    --bg-color: #023877;\r\n    --hover-color-btn: #0074C7;\r\n    --disable-color-btn: #8ab4d1de;\r\n}\r\n\r\n.bg-card[_ngcontent-%COMP%] {\r\n    background: var(--bg-color);\r\n}\r\n\r\n.txt-content[_ngcontent-%COMP%] {\r\n    color: var(--bg-color);\r\n}\r\n\r\n.form__content-submit[_ngcontent-%COMP%] {\r\n    display: flex;\r\n    flex-direction: row;\r\n    justify-content: flex-start;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%] {\r\n    display: block;\r\n    width: 20%;\r\n    font-size: 18px;\r\n    background: var(--bg-color);\r\n    padding: 10px 20px;\r\n    border: none;\r\n    color: #fff;\r\n    font-weight: 700;\r\n    cursor: pointer;\r\n    margin-top: 15px;\r\n    border-radius: 10px;\r\n}\r\n\r\n.form__submit--detail[_ngcontent-%COMP%] {\r\n    margin: 20px;\r\n    width: 30%;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%]:hover {\r\n    background: var(--hover-color-btn);\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%]:disabled {\r\n    background: var(--disable-color-btn);\r\n}\r\n\r\n.icon-style[_ngcontent-%COMP%] {\r\n    color: #fff;\r\n    display: inline-block;\r\n}\r\n\r\ntextarea[_ngcontent-%COMP%] {\r\n    height: 150px;\r\n    resize: none;\r\n}\r\n\r\n.alert-content[_ngcontent-%COMP%] {\r\n    width: 99%;\r\n    display: block;\r\n    align-self: center;\r\n}\r\n\r\n@media screen and (max-width:425px) {\r\n    label[_ngcontent-%COMP%] {\r\n        text-align: center;\r\n        font-size: 1rem;\r\n    }\r\n    small[_ngcontent-%COMP%] {\r\n        font-size: 0.8rem;\r\n        text-align: center;\r\n    }\r\n    .form__content-submit[_ngcontent-%COMP%] {\r\n        justify-content: center;\r\n    }\r\n    .form__submit[_ngcontent-%COMP%] {\r\n        width: 100%;\r\n        font-size: 1rem;\r\n    }\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9jYXBpdHVsby9kZXRhbGxlLWNhcGl0dWxvL2RldGFsbGUtY2FwaXR1bG8uY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLG1CQUFtQjtJQUNuQiwwQkFBMEI7SUFDMUIsOEJBQThCO0FBQ2xDOztBQUVBO0lBQ0ksMkJBQTJCO0FBQy9COztBQUVBO0lBQ0ksc0JBQXNCO0FBQzFCOztBQUVBO0lBQ0ksYUFBYTtJQUNiLG1CQUFtQjtJQUNuQiwyQkFBMkI7QUFDL0I7O0FBRUE7SUFDSSxjQUFjO0lBQ2QsVUFBVTtJQUNWLGVBQWU7SUFDZiwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLFlBQVk7SUFDWixXQUFXO0lBQ1gsZ0JBQWdCO0lBQ2hCLGVBQWU7SUFDZixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLFVBQVU7QUFDZDs7QUFFQTtJQUNJLGtDQUFrQztBQUN0Qzs7QUFFQTtJQUNJLG9DQUFvQztBQUN4Qzs7QUFFQTtJQUNJLFdBQVc7SUFDWCxxQkFBcUI7QUFDekI7O0FBRUE7SUFDSSxhQUFhO0lBQ2IsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFVBQVU7SUFDVixjQUFjO0lBQ2Qsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0k7UUFDSSxrQkFBa0I7UUFDbEIsZUFBZTtJQUNuQjtJQUNBO1FBQ0ksaUJBQWlCO1FBQ2pCLGtCQUFrQjtJQUN0QjtJQUNBO1FBQ0ksdUJBQXVCO0lBQzNCO0lBQ0E7UUFDSSxXQUFXO1FBQ1gsZUFBZTtJQUNuQjtBQUNKIiwiZmlsZSI6InNyYy9hcHAvY29tcG9uZW50cy9jYXBpdHVsby9kZXRhbGxlLWNhcGl0dWxvL2RldGFsbGUtY2FwaXR1bG8uY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIjpyb290IHtcclxuICAgIC0tYmctY29sb3I6ICMwMjM4Nzc7XHJcbiAgICAtLWhvdmVyLWNvbG9yLWJ0bjogIzAwNzRDNztcclxuICAgIC0tZGlzYWJsZS1jb2xvci1idG46ICM4YWI0ZDFkZTtcclxufVxyXG5cclxuLmJnLWNhcmQge1xyXG4gICAgYmFja2dyb3VuZDogdmFyKC0tYmctY29sb3IpO1xyXG59XHJcblxyXG4udHh0LWNvbnRlbnQge1xyXG4gICAgY29sb3I6IHZhcigtLWJnLWNvbG9yKTtcclxufVxyXG5cclxuLmZvcm1fX2NvbnRlbnQtc3VibWl0IHtcclxuICAgIGRpc3BsYXk6IGZsZXg7XHJcbiAgICBmbGV4LWRpcmVjdGlvbjogcm93O1xyXG4gICAganVzdGlmeS1jb250ZW50OiBmbGV4LXN0YXJ0O1xyXG59XHJcblxyXG4uZm9ybV9fc3VibWl0IHtcclxuICAgIGRpc3BsYXk6IGJsb2NrO1xyXG4gICAgd2lkdGg6IDIwJTtcclxuICAgIGZvbnQtc2l6ZTogMThweDtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWJnLWNvbG9yKTtcclxuICAgIHBhZGRpbmc6IDEwcHggMjBweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGNvbG9yOiAjZmZmO1xyXG4gICAgZm9udC13ZWlnaHQ6IDcwMDtcclxuICAgIGN1cnNvcjogcG9pbnRlcjtcclxuICAgIG1hcmdpbi10b3A6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG59XHJcblxyXG4uZm9ybV9fc3VibWl0LS1kZXRhaWwge1xyXG4gICAgbWFyZ2luOiAyMHB4O1xyXG4gICAgd2lkdGg6IDMwJTtcclxufVxyXG5cclxuLmZvcm1fX3N1Ym1pdDpob3ZlciB7XHJcbiAgICBiYWNrZ3JvdW5kOiB2YXIoLS1ob3Zlci1jb2xvci1idG4pO1xyXG59XHJcblxyXG4uZm9ybV9fc3VibWl0OmRpc2FibGVkIHtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWRpc2FibGUtY29sb3ItYnRuKTtcclxufVxyXG5cclxuLmljb24tc3R5bGUge1xyXG4gICAgY29sb3I6ICNmZmY7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbn1cclxuXHJcbnRleHRhcmVhIHtcclxuICAgIGhlaWdodDogMTUwcHg7XHJcbiAgICByZXNpemU6IG5vbmU7XHJcbn1cclxuXHJcbi5hbGVydC1jb250ZW50IHtcclxuICAgIHdpZHRoOiA5OSU7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIGFsaWduLXNlbGY6IGNlbnRlcjtcclxufVxyXG5cclxuQG1lZGlhIHNjcmVlbiBhbmQgKG1heC13aWR0aDo0MjVweCkge1xyXG4gICAgbGFiZWwge1xyXG4gICAgICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICAgICAgICBmb250LXNpemU6IDFyZW07XHJcbiAgICB9XHJcbiAgICBzbWFsbCB7XHJcbiAgICAgICAgZm9udC1zaXplOiAwLjhyZW07XHJcbiAgICAgICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gICAgfVxyXG4gICAgLmZvcm1fX2NvbnRlbnQtc3VibWl0IHtcclxuICAgICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcclxuICAgIH1cclxuICAgIC5mb3JtX19zdWJtaXQge1xyXG4gICAgICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgICAgIGZvbnQtc2l6ZTogMXJlbTtcclxuICAgIH1cclxufSJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](DetalleCapituloComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-detalle-capitulo',
                templateUrl: './detalle-capitulo.component.html',
                styleUrls: ['./detalle-capitulo.component.css']
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_6__["ActivatedRoute"] }, { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"] }, { type: _services_capitulo_service__WEBPACK_IMPORTED_MODULE_7__["CapituloService"] }, { type: _services_marca_libro_service__WEBPACK_IMPORTED_MODULE_8__["MarcaLibroService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslateService"] }]; }, { editTmpl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['editTmpl', { static: true }]
        }], hdrTpl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['hdrTpl', { static: true }]
        }] }); })();


/***/ }),

/***/ "./src/app/components/capitulo/lista-capitulo/lista-capitulo.component.ts":
/*!********************************************************************************!*\
  !*** ./src/app/components/capitulo/lista-capitulo/lista-capitulo.component.ts ***!
  \********************************************************************************/
/*! exports provided: ListaCapituloComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListaCapituloComponent", function() { return ListaCapituloComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @swimlane/ngx-datatable */ "./node_modules/@swimlane/ngx-datatable/__ivy_ngcc__/fesm2015/swimlane-ngx-datatable.js");
/* harmony import */ var _services_libro_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../services/libro.service */ "./src/app/services/libro.service.ts");
/* harmony import */ var _services_capitulo_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../services/capitulo.service */ "./src/app/services/capitulo.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");










const _c0 = ["editTmpl"];
const _c1 = ["hdrTpl"];
function ListaCapituloComponent_option_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const libro_r4 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("value", libro_r4.id);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", libro_r4.nombre, " ");
} }
function ListaCapituloComponent_button_14_Template(rf, ctx) { if (rf & 1) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function ListaCapituloComponent_button_14_Template_button_click_0_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r6); const ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r5.crearCapitulo(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "SHARED.BUTTONS.ADD_CHAPTER"));
} }
function ListaCapituloComponent_div_15_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "VALIDATION.WARNING_LIST"), " ");
} }
function ListaCapituloComponent_div_16_ng_template_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0);
} if (rf & 2) {
    const column_r11 = ctx.column;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](column_r11.name);
} }
function ListaCapituloComponent_div_16_ng_template_4_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
} if (rf & 2) {
    const value_r14 = ctx.value;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", value_r14, " ");
} }
function ListaCapituloComponent_div_16_Template(rf, ctx) { if (rf & 1) {
    const _r16 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "ngx-datatable", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("select", function ListaCapituloComponent_div_16_Template_ngx_datatable_select_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r16); const ctx_r15 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r15.onSelect($event); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, ListaCapituloComponent_div_16_ng_template_2_Template, 1, 1, "ng-template", null, 14, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, ListaCapituloComponent_div_16_ng_template_4_Template, 2, 1, "ng-template", null, 15, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("rows", ctx_r3.capitulos)("columns", ctx_r3.cols)("columnMode", ctx_r3.ColumnMode.force)("headerHeight", 50)("footerHeight", 50)("limit", 10)("selected", ctx_r3.selected)("selectionType", ctx_r3.SelectionType.single);
} }
class ListaCapituloComponent {
    constructor(_libroService, _capituloService, router, _translateService) {
        this._libroService = _libroService;
        this._capituloService = _capituloService;
        this.router = router;
        this._translateService = _translateService;
        this.libros = [];
        this.libroId = 0;
        this.capitulos = [];
        this.cols = [];
        this.selected = [];
        this.SelectionType = _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__["SelectionType"];
        this.ColumnMode = _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__["ColumnMode"];
    }
    ngOnInit() {
        this._libroService.getLibros().subscribe(resp => this.libros = resp);
    }
    buscarCapitulos() {
        this.initColumnsTable();
        this._capituloService.getCapitulosByLIbro(this.libroId).subscribe(resp => {
            this.capitulos = resp;
        });
    }
    initColumnsTable() {
        this.cols = [
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: 'Numero'
            },
            {
                cellTemplate: this.editTmpl,
                headerTemplate: this.hdrTpl,
                name: this._translateService.instant('CHAPTERS.NAME')
            }
        ];
    }
    onSelect({ selected }) {
        this.router.navigate(['/capitulos/form/', selected[0].id]);
    }
    crearCapitulo() {
        this.router.navigate(['/capitulos/form/libro/', this.libroId]);
    }
}
ListaCapituloComponent.ɵfac = function ListaCapituloComponent_Factory(t) { return new (t || ListaCapituloComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_libro_service__WEBPACK_IMPORTED_MODULE_2__["LibroService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_capitulo_service__WEBPACK_IMPORTED_MODULE_3__["CapituloService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"])); };
ListaCapituloComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ListaCapituloComponent, selectors: [["app-lista-capitulo"]], viewQuery: function ListaCapituloComponent_Query(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_c0, true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstaticViewQuery"](_c1, true);
    } if (rf & 2) {
        var _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.editTmpl = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.hdrTpl = _t.first);
    } }, decls: 17, vars: 14, consts: [[1, "card", "mb-3"], [1, "card-header", "text-center", "bg-card", "text-white"], [1, "card-body", "txt-content"], [1, "card-title"], [1, "conteiner__search"], ["aria-label", ".form-select-sm example", 1, "form-select", "form-select-sm", "form-select-own", 3, "ngModel", "ngModelChange"], [3, "value", 4, "ngFor", "ngForOf"], ["type", "button", 1, "form__submit", 3, "click"], ["type", "button", "class", "form__submit", 3, "click", 4, "ngIf"], ["class", "alert alert-info mt-3 mb-2", 4, "ngIf"], [4, "ngIf"], [3, "value"], [1, "alert", "alert-info", "mt-3", "mb-2"], ["rowHeight", "auto", 1, "material", 3, "rows", "columns", "columnMode", "headerHeight", "footerHeight", "limit", "selected", "selectionType", "select"], ["hdrTpl", ""], ["editTmpl", ""]], template: function ListaCapituloComponent_Template(rf, ctx) { if (rf & 1) {
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
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "select", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function ListaCapituloComponent_Template_select_ngModelChange_9_listener($event) { return ctx.libroId = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, ListaCapituloComponent_option_10_Template, 2, 2, "option", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "button", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function ListaCapituloComponent_Template_button_click_11_listener() { return ctx.buscarCapitulos(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](13, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, ListaCapituloComponent_button_14_Template, 3, 3, "button", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, ListaCapituloComponent_div_15_Template, 3, 3, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, ListaCapituloComponent_div_16_Template, 6, 8, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 8, "CHAPTERS.CHAPTER_TITLE"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 10, "CHAPTERS.CHAPTER_LIST"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.libroId);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.libros);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](13, 12, "SHARED.BUTTONS.SEARCH"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.libroId > 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", (ctx.capitulos == null ? null : ctx.capitulos.length) == 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.capitulos.length > 0);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_6__["SelectControlValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["NgModel"], _angular_common__WEBPACK_IMPORTED_MODULE_7__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_7__["NgIf"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_6__["ɵangular_packages_forms_forms_x"], _swimlane_ngx_datatable__WEBPACK_IMPORTED_MODULE_1__["DatatableComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslatePipe"]], styles: ["[_ngcontent-%COMP%]:root {\r\n    --bg-color: #023877;\r\n    --hover-color-btn: #0074C7;\r\n    --disable-color-btn: #8ab4d1de;\r\n}\r\n\r\n.bg-card[_ngcontent-%COMP%] {\r\n    background: var(--bg-color);\r\n    font-size: 18px;\r\n}\r\n\r\n.form-select-own[_ngcontent-%COMP%] {\r\n    width: 70%;\r\n}\r\n\r\n.form__content-submit[_ngcontent-%COMP%] {\r\n    display: flex;\r\n    flex-direction: row;\r\n    justify-content: flex-start;\r\n}\r\n\r\n.conteiner__search[_ngcontent-%COMP%] {\r\n    width: 98%;\r\n    display: flex;\r\n    align-items: baseline;\r\n    gap: 20px;\r\n    margin-bottom: 20px;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%] {\r\n    display: block;\r\n    font-size: 1rem;\r\n    background: var(--bg-color);\r\n    padding: 10px 15px;\r\n    border: none;\r\n    color: #fff;\r\n    font-weight: 700;\r\n    cursor: pointer;\r\n    border-radius: 10px;\r\n}\r\n\r\n.form__submit[_ngcontent-%COMP%]:hover {\r\n    background: var(--hover-color-btn);\r\n}\r\n\r\n@media screen and (max-width:425px) {\r\n    label[_ngcontent-%COMP%] {\r\n        text-align: center;\r\n        font-size: 1rem;\r\n    }\r\n    small[_ngcontent-%COMP%] {\r\n        font-size: 0.8rem;\r\n        text-align: center;\r\n    }\r\n    .conteiner__search[_ngcontent-%COMP%] {\r\n        display: flex;\r\n        flex-direction: column;\r\n        gap: 10px;\r\n    }\r\n    .form-select-own[_ngcontent-%COMP%] {\r\n        width: inherit;\r\n    }\r\n    .form__content-submit[_ngcontent-%COMP%] {\r\n        justify-content: center;\r\n    }\r\n    .form__submit[_ngcontent-%COMP%] {\r\n        width: 100%;\r\n        font-size: 1rem;\r\n    }\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9jYXBpdHVsby9saXN0YS1jYXBpdHVsby9saXN0YS1jYXBpdHVsby5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksbUJBQW1CO0lBQ25CLDBCQUEwQjtJQUMxQiw4QkFBOEI7QUFDbEM7O0FBRUE7SUFDSSwyQkFBMkI7SUFDM0IsZUFBZTtBQUNuQjs7QUFFQTtJQUNJLFVBQVU7QUFDZDs7QUFFQTtJQUNJLGFBQWE7SUFDYixtQkFBbUI7SUFDbkIsMkJBQTJCO0FBQy9COztBQUVBO0lBQ0ksVUFBVTtJQUNWLGFBQWE7SUFDYixxQkFBcUI7SUFDckIsU0FBUztJQUNULG1CQUFtQjtBQUN2Qjs7QUFFQTtJQUNJLGNBQWM7SUFDZCxlQUFlO0lBQ2YsMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixZQUFZO0lBQ1osV0FBVztJQUNYLGdCQUFnQjtJQUNoQixlQUFlO0lBQ2YsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksa0NBQWtDO0FBQ3RDOztBQUVBO0lBQ0k7UUFDSSxrQkFBa0I7UUFDbEIsZUFBZTtJQUNuQjtJQUNBO1FBQ0ksaUJBQWlCO1FBQ2pCLGtCQUFrQjtJQUN0QjtJQUNBO1FBQ0ksYUFBYTtRQUNiLHNCQUFzQjtRQUN0QixTQUFTO0lBQ2I7SUFDQTtRQUNJLGNBQWM7SUFDbEI7SUFDQTtRQUNJLHVCQUF1QjtJQUMzQjtJQUNBO1FBQ0ksV0FBVztRQUNYLGVBQWU7SUFDbkI7QUFDSiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvY2FwaXR1bG8vbGlzdGEtY2FwaXR1bG8vbGlzdGEtY2FwaXR1bG8uY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIjpyb290IHtcclxuICAgIC0tYmctY29sb3I6ICMwMjM4Nzc7XHJcbiAgICAtLWhvdmVyLWNvbG9yLWJ0bjogIzAwNzRDNztcclxuICAgIC0tZGlzYWJsZS1jb2xvci1idG46ICM4YWI0ZDFkZTtcclxufVxyXG5cclxuLmJnLWNhcmQge1xyXG4gICAgYmFja2dyb3VuZDogdmFyKC0tYmctY29sb3IpO1xyXG4gICAgZm9udC1zaXplOiAxOHB4O1xyXG59XHJcblxyXG4uZm9ybS1zZWxlY3Qtb3duIHtcclxuICAgIHdpZHRoOiA3MCU7XHJcbn1cclxuXHJcbi5mb3JtX19jb250ZW50LXN1Ym1pdCB7XHJcbiAgICBkaXNwbGF5OiBmbGV4O1xyXG4gICAgZmxleC1kaXJlY3Rpb246IHJvdztcclxuICAgIGp1c3RpZnktY29udGVudDogZmxleC1zdGFydDtcclxufVxyXG5cclxuLmNvbnRlaW5lcl9fc2VhcmNoIHtcclxuICAgIHdpZHRoOiA5OCU7XHJcbiAgICBkaXNwbGF5OiBmbGV4O1xyXG4gICAgYWxpZ24taXRlbXM6IGJhc2VsaW5lO1xyXG4gICAgZ2FwOiAyMHB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogMjBweDtcclxufVxyXG5cclxuLmZvcm1fX3N1Ym1pdCB7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIGZvbnQtc2l6ZTogMXJlbTtcclxuICAgIGJhY2tncm91bmQ6IHZhcigtLWJnLWNvbG9yKTtcclxuICAgIHBhZGRpbmc6IDEwcHggMTVweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGNvbG9yOiAjZmZmO1xyXG4gICAgZm9udC13ZWlnaHQ6IDcwMDtcclxuICAgIGN1cnNvcjogcG9pbnRlcjtcclxuICAgIGJvcmRlci1yYWRpdXM6IDEwcHg7XHJcbn1cclxuXHJcbi5mb3JtX19zdWJtaXQ6aG92ZXIge1xyXG4gICAgYmFja2dyb3VuZDogdmFyKC0taG92ZXItY29sb3ItYnRuKTtcclxufVxyXG5cclxuQG1lZGlhIHNjcmVlbiBhbmQgKG1heC13aWR0aDo0MjVweCkge1xyXG4gICAgbGFiZWwge1xyXG4gICAgICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICAgICAgICBmb250LXNpemU6IDFyZW07XHJcbiAgICB9XHJcbiAgICBzbWFsbCB7XHJcbiAgICAgICAgZm9udC1zaXplOiAwLjhyZW07XHJcbiAgICAgICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gICAgfVxyXG4gICAgLmNvbnRlaW5lcl9fc2VhcmNoIHtcclxuICAgICAgICBkaXNwbGF5OiBmbGV4O1xyXG4gICAgICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XHJcbiAgICAgICAgZ2FwOiAxMHB4O1xyXG4gICAgfVxyXG4gICAgLmZvcm0tc2VsZWN0LW93biB7XHJcbiAgICAgICAgd2lkdGg6IGluaGVyaXQ7XHJcbiAgICB9XHJcbiAgICAuZm9ybV9fY29udGVudC1zdWJtaXQge1xyXG4gICAgICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xyXG4gICAgfVxyXG4gICAgLmZvcm1fX3N1Ym1pdCB7XHJcbiAgICAgICAgd2lkdGg6IDEwMCU7XHJcbiAgICAgICAgZm9udC1zaXplOiAxcmVtO1xyXG4gICAgfVxyXG59Il19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ListaCapituloComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-lista-capitulo',
                templateUrl: './lista-capitulo.component.html',
                styleUrls: ['./lista-capitulo.component.css']
            }]
    }], function () { return [{ type: _services_libro_service__WEBPACK_IMPORTED_MODULE_2__["LibroService"] }, { type: _services_capitulo_service__WEBPACK_IMPORTED_MODULE_3__["CapituloService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"] }]; }, { editTmpl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['editTmpl', { static: true }]
        }], hdrTpl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['hdrTpl', { static: true }]
        }] }); })();


/***/ }),

/***/ "./src/app/models/capitulo.model.ts":
/*!******************************************!*\
  !*** ./src/app/models/capitulo.model.ts ***!
  \******************************************/
/*! exports provided: Capitulo */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Capitulo", function() { return Capitulo; });
class Capitulo {
}


/***/ }),

/***/ "./src/app/models/create.capitulo.model.ts":
/*!*************************************************!*\
  !*** ./src/app/models/create.capitulo.model.ts ***!
  \*************************************************/
/*! exports provided: CreateCapitulo */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateCapitulo", function() { return CreateCapitulo; });
class CreateCapitulo {
}


/***/ }),

/***/ "./src/app/services/capitulo.service.ts":
/*!**********************************************!*\
  !*** ./src/app/services/capitulo.service.ts ***!
  \**********************************************/
/*! exports provided: CapituloService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CapituloService", function() { return CapituloService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var src_environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");






class CapituloService {
    constructor(http) {
        this.http = http;
        this.urlEndpoint = src_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].urlEndpoint;
        this.controller = 'capitulos';
    }
    getCapitulosByLIbro(id) {
        return this.http.get(`${this.urlEndpoint}/${this.controller}/libro/${id}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(err);
        }));
    }
    getCapitulosByLibroAndPage(id, page) {
        return this.http.get(`${this.urlEndpoint}/${this.controller}/libro/${id}/page/${page}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(err);
        }));
    }
    borrarCapitulo(id) {
        return this.http.delete(`${this.urlEndpoint}/${this.controller}/${id}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['message']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(err);
        }));
    }
    crearCapitulo(createCapitulo) {
        return this.http.post(`${this.urlEndpoint}/${this.controller}`, createCapitulo).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(err);
        }));
    }
    obtenerCapitulo(id) {
        return this.http.get(`${this.urlEndpoint}/${this.controller}/${id}`)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])((resp) => resp['data']), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["catchError"])(err => {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_1__["throwError"])(err);
        }));
    }
}
CapituloService.ɵfac = function CapituloService_Factory(t) { return new (t || CapituloService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"])); };
CapituloService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: CapituloService, factory: CapituloService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CapituloService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] }]; }, null); })();


/***/ })

}]);
//# sourceMappingURL=components-capitulo-capitulo-module.js.map