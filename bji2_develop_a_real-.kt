// Import required libraries
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

// Configure CORS
@RestController
class CorsConfig {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
            }
        }
    }
}

// Create a data class for dashboard data
data class DashboardData(val users: Int, val revenue: Double, val sales: Int)

// Create a controller for the dashboard API
@RestController
class DashboardController {
    @GetMapping("/api/dashboard")
    fun getDashboardData(): DashboardData {
        // Return sample data (replace with actual data from database or API)
        return DashboardData(100, 1000.0, 500)
    }
}

// Main application class
@SpringBootApplication
class Bji2DevelopARealTimeWebAppDashboardApplication

fun main(args: Array<String>) {
    runApplication<Bji2DevelopARealTimeWebAppDashboardApplication>(*args)
}