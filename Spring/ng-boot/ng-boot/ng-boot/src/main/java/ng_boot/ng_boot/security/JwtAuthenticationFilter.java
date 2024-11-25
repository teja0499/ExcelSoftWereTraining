//package ng_boot.ng_boot.security;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.Enumeration;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import ng_boot.ng_boot.dto.User;
//
////@WebFilter("/*")
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Override
//   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//       String authHeader = request.getHeader("Authorization");
//
//       if(authHeader != null && authHeader.startsWith("Bearer ") && !authHeader.substring(7).isBlank()) {
//           String accessToken = authHeader.substring(7);
//           Claims user = JwtUtil.validateToken(accessToken);
//
//           if(user == null) {
//               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//               return;
//           }
//           else {
////               Authentication authenticationToken = new UsernamePasswordAuthenticationToken(user.getId(), null, user.getAuthorities());
////               SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//           }
//       }
//
//       filterChain.doFilter(request, response);
//   }
//    
//    private void logRequestDetails(HttpServletRequest request) throws IOException {
//        // Log Request URI
//        System.out.println("Request URI: " + request.getRequestURI());
//
//        // Log HTTP Method
//        System.out.println("HTTP Method: " + request.getMethod());
//
//        // Log Headers
//        System.out.println("Headers:");
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + request.getHeader(headerName));
//        }
//
//        // Log Query Parameters
//        System.out.println("Query Parameters:");
//        request.getParameterMap().forEach((key, values) -> {
//            System.out.println(key + ": " + String.join(", ", values));
//        });
//
//        // Log Request Body (if applicable)
//        if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
//            BufferedReader reader = request.getReader();
//            StringBuilder body = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                body.append(line).append("\n");
//            }
//            System.out.println("Request Body: " + body.toString());
//        }
//
//        // Log Attributes
//        System.out.println("Attributes:");
//        Enumeration<String> attributeNames = request.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            System.out.println(attributeName + ": " + request.getAttribute(attributeName));
//        }
//    }
//}
