    package Healthy.Healthy.app.controller;

    import Healthy.Healthy.app.entity.Medication;
    import Healthy.Healthy.app.entity.Orders;
    import Healthy.Healthy.app.entity.Pharmacy;
    import Healthy.Healthy.app.service.MedicationService;
    import Healthy.Healthy.app.service.OrderService;
    import Healthy.Healthy.app.service.PharmacyService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/orders")
    public class OrderController {

        private final OrderService orderService;
        private final PharmacyService pharmacyService;
        private final MedicationService medicationService;



        @Autowired
        public OrderController(OrderService orderService, PharmacyService pharmacyService, MedicationService medicationService) {
            this.orderService = orderService;
            this.pharmacyService = pharmacyService;
            this.medicationService = medicationService;
        }

        @GetMapping
        public List<Orders> getAll() {
            return orderService.getAll();
        }

        @GetMapping("/{id}")
        public Orders getById(@PathVariable Long id) {
            return orderService.getById(id);
        }

        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Long id) {
            orderService.deleteById(id);
        }

        @PostMapping
        public Orders create(@RequestBody Orders order) {
            return orderService.create(order);
        }

        @PutMapping("/{id}")
        public Orders updateById(@RequestBody Orders order, @PathVariable Long id) {
            return orderService.updateById(order, id);
        }
        @GetMapping("/pharmacy")
        public ResponseEntity<List<Pharmacy>> getPharmacyOptions() {
            List<Pharmacy> pharmacyList = pharmacyService.getAllPharmacies();
            return ResponseEntity.ok(pharmacyList);
        }
        @GetMapping("/medication")
        public ResponseEntity<List<Medication>> getMedicationOptions() {
            List<Medication> clinics = medicationService.getAll();
            return ResponseEntity.ok(clinics);
        }
    }

