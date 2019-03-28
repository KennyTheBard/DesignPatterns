
class ChainOfResponsibility {

    static abstract class Handler {

        private Handler succesor;

        Handler(Handler succesor) {
            this.succesor = succesor;
        }

        void handleRequest(int request) {
            if (this.succesor != null) {
                this.succesor.handleRequest(request);
            }
        }
    }

    public static void main(String[] args) {
        Handler h = new Handler(
                        new Handler(
                            new Handler(null)
                            {
                                void handleRequest(int request) {
                                    super.handleRequest(request);
                                    request += 10;
                                    System.out.println("Current request value: " + request);
                                }
                            }
                        ){
                            void handleRequest(int request)
                            {
                                super.handleRequest(request);
                                request *= 2;
                                System.out.println("Current request value: " + request);
                            }
                        }
                    ){
                        void handleRequest(int request) {
                            super.handleRequest(request);
                            request %= 2;
                            System.out.println("Current request value: " + request);
                        }
                    };

        h.handleRequest(7);
    }
}
