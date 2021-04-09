<?php

namespace App\Controller;

use App\Entity\Postes;
use App\Form\PostesType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/postes")
 */
class PostesController extends AbstractController
{
    /**
     * @Route("/", name="postes_index", methods={"GET"})
     */
    public function index(): Response
    {
        $postes = $this->getDoctrine()
            ->getRepository(Postes::class)
            ->findAll();

        return $this->render('postes/index.html.twig', [
            'postes' => $postes,
        ]);
    }

    /**
     * @Route("/new", name="postes_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $poste = new Postes();
        $form = $this->createForm(PostesType::class, $poste);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($poste);
            $entityManager->flush();

            return $this->redirectToRoute('postes_index');
        }

        return $this->render('postes/new.html.twig', [
            'poste' => $poste,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idPost}", name="postes_show", methods={"GET"})
     */
    public function show(Postes $poste): Response
    {
        return $this->render('postes/show.html.twig', [
            'poste' => $poste,
        ]);
    }

    /**
     * @Route("/{idPost}/edit", name="postes_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Postes $poste): Response
    {
        $form = $this->createForm(PostesType::class, $poste);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('postes_index');
        }

        return $this->render('postes/edit.html.twig', [
            'poste' => $poste,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idPost}", name="postes_delete", methods={"POST"})
     */
    public function delete(Request $request, Postes $poste): Response
    {
        if ($this->isCsrfTokenValid('delete'.$poste->getIdPost(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($poste);
            $entityManager->flush();
        }

        return $this->redirectToRoute('postes_index');
    }
}
